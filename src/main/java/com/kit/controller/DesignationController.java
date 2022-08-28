package com.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kit.entity.Designation;
import com.kit.service.DesignationService;
import com.kit.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Controller
@RequestMapping("/designation")
public class DesignationController {

	@Autowired private DesignationService desService;

	@GetMapping
	public String loadDesignationForm(Model model) {
		model.addAttribute("des", new Designation());
		model.addAttribute("desList", desService.getAll());
		return "designation";
	}

	@GetMapping("/{id}")
	public String loadDesignationForm(@PathVariable Long id, Model model) {
		model.addAttribute("des", desService.find(id));
		model.addAttribute("desList", desService.getAll());
		return "designation";
	}

	@PostMapping
	public String saveDesignation(Designation designation, Model model, RedirectAttributes ra) {
		designation = desService.save(designation);
		if(designation == null || designation.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/designation";
		} else {
			ra.addFlashAttribute("res", new Response(true, "Saved"));
			return "redirect:/designation";
		}
	}
}
