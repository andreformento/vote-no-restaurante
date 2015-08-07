package br.com.formento.voteNoRestaurante.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.Vote;
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
		List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
		for (Restaurant restaurant : allRestaurants)
			System.out.println(restaurant);
		
		return "index";
	}

	@RequestMapping("/vote")
	public String vote(Model model) {
		List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
		Restaurant restaurant = allRestaurants.get(0);

		Vote vote = new Vote(new Date(), "andreformento.sc@gmail.com", restaurant);
		voteService.createVote(vote);

		List<Vote> allVotes = voteService.getAllVotes();
		for (Vote v : allVotes)
			System.out.println(v);

		model.addAttribute("count", allVotes.size());

		return "index";
	}

}