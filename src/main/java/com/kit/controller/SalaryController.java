package com.kit.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.kit.entity.Grade;
import com.kit.entity.GradeDetail;
import com.kit.entity.Salary;
import com.kit.entity.SalaryBreakdown;
import com.kit.entity.User;
import com.kit.service.EmployeeService;
import com.kit.service.GradeDetailService;
import com.kit.service.GradeService;
import com.kit.service.SalaryService;
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
@RequestMapping("/salary")
public class SalaryController {

	private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	private static final SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired 
	private SalaryService salService;
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService empService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private GradeDetailService gradeDetailService;

	@GetMapping
	public String load(Model model) {
		return "redirect:/salary/search/" + monthFormat.format(new Date()) + "/" + yearFormat.format(new Date());
	}

	@PostMapping("/search")
	public String search(SalarySearchBody s, Model model) {
		model.addAttribute("s", s);
		loadpage(s.getMonth(), s.getYear(), model);
		return "salary";
	}

	@GetMapping("/search/{month}/{year}")
	public String search(@PathVariable String month, @PathVariable Integer year, Model model) throws ParseException {
		SalarySearchBody s = new SalarySearchBody(month.toUpperCase(), year);
		model.addAttribute("s", s);
		loadpage(s.getMonth(), s.getYear(), model);
		return "salary";
	}

	private void loadpage(String month, Integer year, Model model) {
		List<User> userList = userService.getAll();
		for(User u : userList) {
			Employee e = empService.getByUserId(u.getId());
			if(e == null) continue;
			Grade grade = gradeService.find(e.getGradeId());
			grade.setGradeDetails(gradeDetailService.getAll(grade.getId()));
			e.setGrade(grade);
			u.setEmployee(e);
		}

		List<Salary> lmList = salService.getAllByMonthAndYear(month, String.valueOf(year));

		// TODO: filter user from joining date month

		List<Salary> finalLeaveManagers = new ArrayList<>();
		for (User u : userList) {
			Salary salary = new Salary();
			List<Salary> filteredForUser = lmList.stream().filter(f -> f.getUserId().equals(u.getId())).collect(Collectors.toList());
			if (!filteredForUser.isEmpty()) {
				salary = filteredForUser.get(0);
				salary.setUserId(u.getId());
				salary.setUsername(u.getUsername());
			} else {
				salary.setUserId(u.getId());
				salary.setUsername(u.getUsername());
				if(u.getEmployee() != null) {
					salary.setTotalSalary(u.getEmployee().getTotalSalary() == null ? BigDecimal.ZERO : u.getEmployee().getTotalSalary());
					Grade g = u.getEmployee().getGrade();
					if(g != null && !g.getGradeDetails().isEmpty()) {
						List<SalaryBreakdown> sbList = new ArrayList<>();
						for(GradeDetail gd : g.getGradeDetails()) {
							SalaryBreakdown sb = new SalaryBreakdown();
							sb.setName(gd.get);
							
							sbList.add(sb);
						}
						salary.setBreakdown(sbList);
					}
				}
				
				
			}
			finalLeaveManagers.add(salary);
		}

		model.addAttribute("lmList", finalLeaveManagers);
	}

	@PostMapping(value = "/save", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> save(@RequestBody String json) {
		SalaryManagerSheet c = new SalaryManagerSheet();
		ObjectMapper obm = new ObjectMapper();
		obm.setDateFormat(sdf);
		obm.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			JsonNode rootNode = obm.readTree(json);
			JsonNode query = rootNode.get("fas");
			c = obm.readValue(query.toString(), SalaryManagerSheet.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		for(Salary l : c.getLmList()) {
			l.setYear(c.getYear());
		}

		salService.save(c.getLmList());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Saved Successfully");
		map.put("redirectUrl", "/salary/search/" + c.getMonth() + "/" + c.getYear());
		return map;
	}
	
	
	
}

@Data
class SalaryManagerSheet{
	private String year;
	private String month;
	private List<Salary> lmList = new ArrayList<>();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class SalarySearchBody {
	private String month;
	private Integer year;
	private List<Integer> years = new Util().lastNthYearList(5);

	SalarySearchBody(String month, Integer year){
		this.month = month;
		this.year = year;
		this.years = new Util().lastNthYearList(5);
	}
}
