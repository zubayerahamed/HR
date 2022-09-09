package com.kit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kit.entity.Employee;
import com.kit.entity.LeaveManager;
import com.kit.entity.User;
import com.kit.service.EmployeeService;
import com.kit.service.GradeService;
import com.kit.service.LeaveManagerService;
import com.kit.service.UserService;
import com.kit.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 28, 2022
 */
@Controller
@RequestMapping("/leave-manager")
public class LeaveManagerController {

	private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private LeaveManagerService lmService;
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService empService;
	@Autowired
	private GradeService gradeService;

	@GetMapping
	public String load(Model model) {
		return "redirect:/leave-manager/search/" + yearFormat.format(new Date());
	}

	@PostMapping("/search")
	public String search(LeaveManagerSearchBody s, Model model) {
		model.addAttribute("s", s);
		loadpage(s.getYear(), model);
		return "leave-manager";
	}

	@GetMapping("/search/{year}")
	public String search(@PathVariable Integer year, Model model) throws ParseException {
		LeaveManagerSearchBody s = new LeaveManagerSearchBody(year);
		model.addAttribute("s", s);
		loadpage(s.getYear(), model);
		return "leave-manager";
	}

	private void loadpage(Integer year, Model model) {
		List<User> userList = userService.getAll();
		for(User u : userList) {
			Employee e = empService.getByUserId(u.getId());
			if(e == null) continue;
			e.setGrade(gradeService.find(e.getGradeId()));
			u.setEmployee(e);
		}

		List<LeaveManager> lmList = lmService.getAllByYear(String.valueOf(year));

		// TODO: filter user from joining date month

		List<LeaveManager> finalLeaveManagers = new ArrayList<>();
		for (User u : userList) {
			LeaveManager lm = new LeaveManager();
			List<LeaveManager> filteredForUser = lmList.stream().filter(f -> f.getUserId().equals(u.getId())).collect(Collectors.toList());
			if (!filteredForUser.isEmpty()) {
				lm = filteredForUser.get(0);
				lm.setUserId(u.getId());
				lm.setUsername(u.getUsername());
			} else {
				lm.setUserId(u.getId());
				lm.setUsername(u.getUsername());
				if(u.getEmployee() != null) lm.setTotalAllocatedLeave(u.getEmployee().getGrade().getAllocatedLeave());
			}
			finalLeaveManagers.add(lm);
		}

		finalLeaveManagers.sort(Comparator.comparing(LeaveManager::getUsername));
		model.addAttribute("lmList", finalLeaveManagers);
	}

	@PostMapping(value = "/save", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> save(@RequestBody String json) {
		LeaveManagerSheet c = new LeaveManagerSheet();
		ObjectMapper obm = new ObjectMapper();
		obm.setDateFormat(sdf);
		obm.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			JsonNode rootNode = obm.readTree(json);
			JsonNode query = rootNode.get("fas");
			c = obm.readValue(query.toString(), LeaveManagerSheet.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		for(LeaveManager l : c.getLmList()) {
			l.setYear(c.getYear());
		}

		lmService.save(c.getLmList());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Saved Successfully");
		map.put("redirectUrl", "/leave-manager/search/" + c.getYear());
		return map;
	}
	
	
	
}

@Data
class LeaveManagerSheet{
	private String year;
	private List<LeaveManager> lmList = new ArrayList<>();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class LeaveManagerSearchBody {
	private Integer year;
	private List<Integer> years = new Util().lastNthYearList(5);
	
	LeaveManagerSearchBody(Integer year){
		this.year = year;
		this.years = new Util().lastNthYearList(5);
	}
}
