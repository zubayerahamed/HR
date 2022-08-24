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

import com.kit.entity.Grade;
import com.kit.entity.GradeDetail;
import com.kit.entity.Transaction;
import com.kit.service.GradeDetailService;
import com.kit.service.GradeService;
import com.kit.service.TransactionService;
import com.kit.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Controller
@RequestMapping("/grade")
public class GradeController {

	@Autowired private GradeService grService;
	@Autowired private GradeDetailService grdService;
	@Autowired private TransactionService trnService;

	@GetMapping
	public String loadGradeForm(Model model) {
		model.addAttribute("gr", new Grade());
		model.addAttribute("grList", grService.getAll());
		return "grade";
	}

	@GetMapping("/{id}")
	public String loadGradeForm(@PathVariable Long id, Model model) {
		model.addAttribute("gr", grService.find(id));
		model.addAttribute("grList", grService.getAll());
		return "grade";
	}

	@PostMapping
	public String save(Grade grade, Model model, RedirectAttributes ra) {
		grade = grService.save(grade);
		if(grade == null || grade.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/grade";
		} else {
			ra.addFlashAttribute("res", new Response(true, "Saved"));
			return "redirect:/grade/" + grade.getId();
		}
	}

	@GetMapping("/detail/{id}")
	public String loadGradeDetailForm(@PathVariable Long id, Model model) {
		model.addAttribute("gr", grService.find(id));
		model.addAttribute("grd", new GradeDetail());
		List<GradeDetail> grdList = grdService.getAll(id); 
		grdList.stream().forEach(g -> {
			Transaction t = trnService.find(g.getTransactionId());
			if(t != null) g.setTransactionName(t.getName());
		});
		model.addAttribute("grdList", grdList);
		model.addAttribute("trnList", trnService.getAll());
		return "grade-detail";
	}

}
