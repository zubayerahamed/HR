package com.kit.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.kit.entity.LeaveManager;
import com.kit.entity.Salary;
import com.kit.entity.SalaryBreakdown;
import com.kit.entity.Transaction;
import com.kit.entity.User;
import com.kit.enums.AmountType;
import com.kit.enums.TransactionType;
import com.kit.service.AttendanceService;
import com.kit.service.EmployeeService;
import com.kit.service.FoodService;
import com.kit.service.GradeDetailService;
import com.kit.service.GradeService;
import com.kit.service.LeaveManagerService;
import com.kit.service.SalaryService;
import com.kit.service.SettingsService;
import com.kit.service.TransactionService;
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
	@Autowired
	private TransactionService trnService;
	@Autowired
	private LeaveManagerService lmService;
	@Autowired
	private AttendanceService attService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private SettingsService setService;

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
					// total salary
					salary.setTotalSalary(u.getEmployee().getTotalSalary() == null ? BigDecimal.ZERO : u.getEmployee().getTotalSalary());

					// breakdown
					Grade g = u.getEmployee().getGrade();
					if(g != null && !g.getGradeDetails().isEmpty()) {
						List<SalaryBreakdown> sbList = new ArrayList<>();
						for(GradeDetail gd : g.getGradeDetails()) {
							SalaryBreakdown sb = new SalaryBreakdown();
							Transaction t = trnService.find(gd.getTransactionId());
							sb.setName(t.getName());
							sb.setTrnType(t.getTransactionType());
							sb.setAmountType(gd.getType());
							sb.setAmount(gd.getAmount());
							sb.setGradeName(g.getCode());
							sbList.add(sb);
						}
						salary.setBreakdown(sbList);
					}

					// payable
					for(SalaryBreakdown sb : salary.getBreakdown()) {
						if(sb.getTrnType().equals(TransactionType.DEDUCTION)) {
							if(sb.getAmountType().equals(AmountType.PERCENT)) {
								salary.setPayableAfterBreakDown(salary.getTotalSalary().subtract(salary.getTotalSalary().multiply(sb.getAmount()).divide(BigDecimal.valueOf(100))).setScale(2, RoundingMode.DOWN));
							} else {
								salary.setPayableAfterBreakDown(salary.getTotalSalary().subtract(salary.getTotalSalary().subtract(sb.getAmount())).setScale(2, RoundingMode.DOWN));
							}
						}
					}
				}
				
				// total taken leave
				LeaveManager lm = lmService.findByUserIdAndYear(salary.getUserId(), year.toString());
				if(lm != null) salary.setTotalLeaveTakenInYear(lm.getAlreadyTaken());
				try {
					salary.setTotalWorkingDaysInMonth(new Util().totalDaysOfMonth(month, year.toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				salary.setTotalAttendInMonth(attService.totalPresentInMonth(salary.getUserId(), month, year.toString()));
				salary.setLeaveTakenInMonth(attService.totalAbsentInMonth(salary.getUserId(), month, year.toString()));
				salary.setTotalLateInMonth(attService.totalLateDaysInMonth(salary.getUserId(), month, year.toString()));
				int unpaidLeave = attService.totalUnpaidLeaveInMonth(salary.getUserId(), month, year.toString());
				salary.setTotalUnpaidLeaveInMonth(unpaidLeave);
				if(salary.getTotalSalary() == null || salary.getTotalSalary().compareTo(BigDecimal.ZERO) == 0) {
					salary.setUnpaidLeaveAmount(BigDecimal.ZERO);
				} else {
					BigDecimal a = BigDecimal.valueOf(new Double(salary.getTotalWorkingDaysInMonth())).setScale(2, RoundingMode.DOWN);
					BigDecimal cal = salary.getTotalSalary().setScale(2, RoundingMode.DOWN).divide(a, 2, RoundingMode.DOWN).setScale(2, RoundingMode.DOWN);
					salary.setUnpaidLeaveAmount(cal.multiply(BigDecimal.valueOf(new Double(unpaidLeave))).setScale(2, RoundingMode.DOWN));
				}
				salary.setTotalFoodDaysInMonth(foodService.totalFoodDaysInMonth(salary.getUserId(), month, year.toString()));
				salary.setFoodBillInMonth(setService.getAll().get(0).getFoodBill().multiply(BigDecimal.valueOf(new Double(salary.getTotalFoodDaysInMonth()))).setScale(2, RoundingMode.DOWN));
			
				salary.setNetPayable(salary.getPayableAfterBreakDown().subtract(salary.getUnpaidLeaveAmount()).subtract(salary.getFoodBillInMonth()));
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
