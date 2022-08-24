package com.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kit.entity.Transaction;
import com.kit.service.TransactionService;
import com.kit.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired private TransactionService trnService;

	
	@GetMapping
	public String loadTransactionPage(Model model) {
		model.addAttribute("trn", new Transaction());
		model.addAttribute("trnList", trnService.getAll());
		return "transaction";
	}

	@GetMapping("/{id}")
	public String loadTransactionPage(@PathVariable Long id, Model model) {
		model.addAttribute("trn", trnService.find(id));
		model.addAttribute("trnList", trnService.getAll());
		return "transaction";
	}

	@PostMapping
	public String saveTransaction(Transaction tran, Model model, RedirectAttributes ra) {
		tran = trnService.save(tran);
		if(tran == null || tran.getId() == null) {
			ra.addFlashAttribute("res", new Response(false, "Can't save"));
			return "redirect:/transaction";
		} else {
			ra.addFlashAttribute("res", new Response(true, "Saved"));
			return "redirect:/transaction/" + tran.getId();
		}
	}
}
