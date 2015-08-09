package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;

public interface CategoryRestaurantRepository extends Repository<CategoryRestaurant> {

	List<CategoryRestaurant> getEntities();

}