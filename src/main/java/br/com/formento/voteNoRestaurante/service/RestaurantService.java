package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;

public interface RestaurantService extends EntityService<Restaurant> {

	List<Restaurant> getEntities();

	List<Restaurant> getEntitiesByCategory(CategoryRestaurant categoryRestaurant);

}