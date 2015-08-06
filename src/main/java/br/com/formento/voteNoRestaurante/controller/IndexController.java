package br.com.formento.voteNoRestaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Working");
		model.addAttribute("tagline", "Vote!");

		return "index";
	}

}