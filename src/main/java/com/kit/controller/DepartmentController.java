package com.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kit.entity.Department;
import com.kit.service.DepartmentService;
import com.kit.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired private DepartmentService depService;

	@GetMapping
	public String loadDepartmentForm(Model model) {
		model.addAttribute("dep", new Department());
		model.addAttribute("depList", depService.getAll());
		return "department";
	}

	@GetMapping("/{id}")
	public String loadDepartmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("dep", depService.find(id));
		model.addAttribute("depList", depService.getAll());
		return "department";
	}

	@PostMapping
	public String saveDepartment(Department department, Model model, RedirectAttributes ra) {
		department = depService.save(department);
		if(department == null || department.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/department";
		} else {
			ra.addFlashAttribute("res", new Response(true, "Saved"));
			return "redirect:/department/" + department.getId();
		}
	}
}
