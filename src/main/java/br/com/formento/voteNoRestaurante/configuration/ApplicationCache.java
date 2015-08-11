package br.com.formento.voteNoRestaurante.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
//		 CategoryRestaurant categoryRestaurant = new CategoryRestaurant("Fast food", 1);
//		 System.out.println(categoryRestaurantService.getEntities());
//		 categoryRestaurantService.createEntity(categoryRestaurant);
		//
		// //CategoryRestaurant categoryRestaurantLoad = categoryRestaurantService.getEntityById(1l);
		// Restaurant restaurant = new Restaurant("res1", categoryRestaurantLoad);
		// restaurantService.createEntity(restaurant);
	}

}