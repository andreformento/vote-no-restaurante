package br.com.formento.voteNoRestaurante.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.service.RestaurantService;

@SpringBootApplication
public class ApplicationCache {

	@Autowired
	private RestaurantService restaurantService;

	@PostConstruct
	public void populateRestaurant() {
		restaurantService.createRestaurant(new Restaurant("res1"));
	}

}