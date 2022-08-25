package com.kit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kit.entity.Attendance;
import com.kit.entity.User;
import com.kit.service.AttendanceService;
import com.kit.service.UserService;
import com.kit.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired private UserService userService;
	@Autowired private AttendanceService foodService;

	@GetMapping
	public String loadPage(Model model) {
		return "redirect:/attendance/search/" + sdf.format(new Date());
	}

	@PostMapping("/search")
	public String search(AttendanceSearchBody s, Model model) {
		model.addAttribute("s", s);
		loadpage(s.getDate(), model);
		return "attendance";
	}

	@GetMapping("/search/{date}")
	public String search(@PathVariable String date, Model model) throws ParseException {
		AttendanceSearchBody s = new AttendanceSearchBody(sdf.parse(date));
		model.addAttribute("s", s);
		loadpage(s.getDate(), model);
		return "attendance";
	}

	private void loadpage(Date date, Model model) {
		List<User> userList = userService.getAll();
		List<Attendance> attendanceList = foodService.findByDate(date);

		// TODO: filter user from joining date month

		// merge food entry with users
		List<Attendance> finalAttendanceTable = new ArrayList<>();
		for(User u : userList) {
			Attendance attendance = new Attendance();
			List<Attendance> filteredForUser = attendanceList.stream().filter(f -> f.getUserId().equals(u.getId())).collect(Collectors.toList());
			if(!filteredForUser.isEmpty()) {
				attendance = filteredForUser.get(0);
				attendance.setUserId(u.getId());
				attendance.setUsername(u.getUsername());
			} else {
				attendance.setUserId(u.getId());
				attendance.setUsername(u.getUsername());
			}
			finalAttendanceTable.add(attendance);
		}

		model.addAttribute("attendanceList", finalAttendanceTable);
	}

	@PostMapping(value = "/save", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> save(@RequestBody String json) {
		AttendanceSheet c = new AttendanceSheet();
		ObjectMapper obm = new ObjectMapper();
		obm.setDateFormat(sdf);
		try {
			JsonNode rootNode = obm.readTree(json);
			JsonNode query = rootNode.get("fas");
			c = obm.readValue(query.toString(), AttendanceSheet.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		List<Attendance> attendaces = new ArrayList<>();
		for(Attendance i : c.getAttendacnes()){
			i.setDate(c.getDate());
			i.setMonth(Util.getMonthFromDate(c.getDate()));
			i.setYear(Util.getYearFromDate(c.getDate()));

			attendaces.add(i);
		}

		foodService.save(attendaces);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Saved Successfully");
		map.put("redirectUrl", "/attendance/search/" + sdf.format(c.getDate()));
		return map;
	}
	
}

@Data
class AttendanceSheet{
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private List<Attendance> attendacnes = new ArrayList<>();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AttendanceSearchBody{
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
}
