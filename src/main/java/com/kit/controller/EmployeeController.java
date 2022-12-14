package com.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kit.entity.Employee;
import com.kit.service.DepartmentService;
import com.kit.service.DesignationService;
import com.kit.service.EmployeeService;
import com.kit.service.GradeService;
import com.kit.service.UserService;
import com.kit.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired private EmployeeService empService;
	@Autowired private UserService usService;
	@Autowired private GradeService gradService;
	@Autowired private DepartmentService depService;
	@Autowired private DesignationService desService;

	@GetMapping
	public String loadEmpForm(Model model) {
		model.addAttribute("emp", new Employee());
		model.addAttribute("empList", empService.getAll());
		model.addAttribute("usList", usService.getAll());
		model.addAttribute("grList", gradService.getAll());
		model.addAttribute("depList", depService.getAll());
		model.addAttribute("desList", desService.getAll());
		return "employee";
	}

	@GetMapping("/{id}")
	public String loadEmpForm(@PathVariable Long id, Model model) {
		model.addAttribute("emp", empService.find(id));
		model.addAttribute("empList", empService.getAll());
		model.addAttribute("usList", usService.getAll());
		model.addAttribute("grList", gradService.getAll());
		model.addAttribute("depList", depService.getAll());
		model.addAttribute("desList", desService.getAll());
		return "employee";
	}

	@PostMapping
	public String save(Employee emp, Model model, RedirectAttributes ra) {
		emp = empService.save(emp);
		if(emp == null || emp.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/employee";
		} else {
			ra.addFlashAttribute("res", new Response(true, "Saved"));
			return "redirect:/employee";
		}
	}
}
