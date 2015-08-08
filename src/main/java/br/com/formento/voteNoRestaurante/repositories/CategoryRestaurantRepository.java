package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;

public interface CategoryRestaurantRepository {

	List<CategoryRestaurant> getEntities();

	Long save(CategoryRestaurant entity);

}