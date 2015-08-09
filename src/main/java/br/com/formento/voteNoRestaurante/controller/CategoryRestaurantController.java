package br.com.formento.voteNoRestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.service.CategoryRestaurantService;

@Controller
@RequestMapping("/categoryRestaurant")
public class CategoryRestaurantController {

	@Autowired
	private CategoryRestaurantService categoryRestaurantService;

	@RequestMapping("/list")
	public String welcome(Model model) {
		List<CategoryRestaurant> categoryRestaurantList = categoryRestaurantService.getEntities();

		model.addAttribute("categoryRestaurantList", categoryRestaurantList);

		return "categoryRestaurant/list";
	}

}