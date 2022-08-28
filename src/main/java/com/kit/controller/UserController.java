package com.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kit.entity.User;
import com.kit.service.UserService;
import com.kit.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired private UserService uService;

	@GetMapping
	public String loadUserPage(Model model) {
		model.addAttribute("us", new User());
		model.addAttribute("usList", uService.getAll());
		return "user";
	}

	@GetMapping("/{id}")
	public String loadUserPage(@PathVariable Long id, Model model) {
		model.addAttribute("us", uService.find(id));
		model.addAttribute("usList", uService.getAll());
		return "user";
	}

	@PostMapping
	public String save(User user, Model model, RedirectAttributes ra) {
		user = uService.save(user);
		if(user == null || user.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/user";
		} else {
			ra.addFlashAttribute("res", new Response(true, "Saved"));
			return "redirect:/user";
		}
	}
}
