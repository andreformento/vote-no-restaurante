package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.FormChoiceRestaurant;

public interface CategoryRestaurantService extends EntityService<CategoryRestaurant> {

	List<CategoryRestaurant> getEntities();

	CategoryRestaurant getNextByOrder(int order);

	FormChoiceRestaurant getFormChoiceRestaurant(RestaurantService restaurantService, int order);

}