package com.kit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String loadHomePage(Model model) {
		return "index";
	}
}
