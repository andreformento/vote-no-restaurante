package br.com.formento.voteNoRestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.voteNoRestaurante.service.RestaurantService;
import br.com.formento.voteNoRestaurante.service.VoteService;

@Controller
public class IndexController {

	@Autowired
	private VoteService voteService;

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping("/")
	public String welcome(Model model) {
		return "index";
	}

//	@RequestMapping("/vote")
//	public String vote(Model model) {
//		List<Restaurant> allRestaurants = restaurantService.getEntities();
//		Restaurant restaurant = allRestaurants.get(0);
//
//		Vote vote = new Vote(new Date(),  restaurant, new );
//		voteService.createEntity(vote);
//
//		List<Vote> allVotes = voteService.getEntities();
//
//		model.addAttribute("count", allVotes.size());
//
//		return "index";
//	}

}