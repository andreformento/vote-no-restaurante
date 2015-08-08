package br.com.formento.voteNoRestaurante.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.service.CategoryRestaurantService;
import br.com.formento.voteNoRestaurante.service.RestaurantService;

@SpringBootApplication
public class ApplicationCache {

	@Autowired
	private CategoryRestaurantService categoryRestaurantService;

	@Autowired
	private RestaurantService restaurantService;

	@PostConstruct
	public void populateRestaurant() {
		// TODO ver porque está gerando erro ao iniciar aplicação
		CategoryRestaurant categoryRestaurant = new CategoryRestaurant("Fast food", 1);
		categoryRestaurantService.createEntity(categoryRestaurant);

		Restaurant restaurant = new Restaurant("res1", categoryRestaurant);
		restaurantService.createEntity(restaurant);
	}

}