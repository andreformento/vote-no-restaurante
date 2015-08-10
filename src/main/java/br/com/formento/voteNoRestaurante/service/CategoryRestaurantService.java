package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;

public interface CategoryRestaurantService extends EntityService<CategoryRestaurant> {

	List<CategoryRestaurant> getEntities();

	CategoryRestaurant getNextByOrder(int order);

}