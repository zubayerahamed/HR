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
import com.kit.entity.Food;
import com.kit.entity.User;
import com.kit.service.FoodService;
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
@RequestMapping("/food")
public class FoodController {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired private UserService userService;
	@Autowired private FoodService foodService;

	@GetMapping
	public String loadPage(Model model) {
		return "redirect:/food/search/" + sdf.format(new Date());
	}

	@PostMapping("/search")
	public String search(SearchBody s, Model model) {
		model.addAttribute("s", s);
		loadpage(s.getDate(), model);
		return "food";
	}

	@GetMapping("/search/{date}")
	public String search(@PathVariable String date, Model model) throws ParseException {
		SearchBody s = new SearchBody(sdf.parse(date));
		model.addAttribute("s", s);
		loadpage(s.getDate(), model);
		return "food";
	}

	private void loadpage(Date date, Model model) {
		List<User> userList = userService.getAll();
		List<Food> foodList = foodService.findByDate(date);

		// TODO: filter user from joining date month

		// merge food entry with users
		List<Food> finalFoodTable = new ArrayList<>();
		for(User u : userList) {
			Food food = new Food();
			List<Food> filteredForUser = foodList.stream().filter(f -> f.getUserId().equals(u.getId())).collect(Collectors.toList());
			if(!filteredForUser.isEmpty()) {
				food = filteredForUser.get(0);
				food.setUserId(u.getId());
				food.setUsername(u.getUsername());
			} else {
				food.setUserId(u.getId());
				food.setUsername(u.getUsername());
			}
			finalFoodTable.add(food);
		}

		finalFoodTable.sort(Comparator.comparing(Food::getUsername));
		model.addAttribute("foodList", finalFoodTable);
	}

	@PostMapping(value = "/save", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> save(@RequestBody String json) {
		FoodAttendanceSheet c = new FoodAttendanceSheet();
		ObjectMapper obm = new ObjectMapper();
		obm.setDateFormat(sdf);
		try {
			JsonNode rootNode = obm.readTree(json);
			JsonNode query = rootNode.get("fas");
			c = obm.readValue(query.toString(), FoodAttendanceSheet.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		List<Food> foods = new ArrayList<>();
		for(Food i : c.getFoods()){
			i.setDate(c.getDate());
			i.setMonth(Util.getMonthFromDate(c.getDate()));
			i.setYear(Util.getYearFromDate(c.getDate()));

			foods.add(i);
		}

		foodService.save(foods);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Saved Successfully");
		map.put("redirectUrl", "/food/search/" + sdf.format(c.getDate()));
		return map;
	}
	
}

@Data
class FoodAttendanceSheet{
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private List<Food> foods = new ArrayList<>();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class SearchBody{
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
}
