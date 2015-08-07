package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Restaurant;

public interface RestaurantService {

	List<Restaurant> getAllRestaurants();

	void createRestaurant(Restaurant restaurant);

}