package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;

public interface CategoryRestaurantService extends EntityService<CategoryRestaurant> {

	List<CategoryRestaurant> getEntities();

	CategoryRestaurant getNextByOrder(int order);

	ComputationVote getComputationVote(List<Long> idRestaurantList);

}