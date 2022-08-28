package com.kit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kit.entity.Settings;
import com.kit.service.SettingsService;
import com.kit.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Controller
@RequestMapping("/settings")
public class SettingsController {

	@Autowired private SettingsService sService;

	@GetMapping
	public String load(Model model) {
		model.addAttribute("set", new Settings());
		
		List<Settings> s = sService.getAll();
		Settings setting = s.stream().findFirst().orElse(null);
		if(setting != null) {
			return "redirect:/settings/" + setting.getId();
		}
		
		model.addAttribute("setList", s);
		return "settings";
	}

	@GetMapping("/{id}")
	public String load(@PathVariable Long id, Model model) {
		model.addAttribute("set", sService.find(id));
		model.addAttribute("setList", sService.getAll());
		return "settings";
	}

	@PostMapping
	public String save(Settings set, Model model, RedirectAttributes ra) {
		if(!sService.getAll().isEmpty() && set.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/settings";
		}

		set = sService.save(set);
		if(set == null || set.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/settings";
		} else {
			ra.addFlashAttribute("res", new Response(true, "Saved"));
			return "redirect:/settings";
		}
	}
}
