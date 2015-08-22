package br.com.formento.voteNoRestaurante.repository;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Restaurant;

public interface RestaurantRepository extends Repository<Restaurant> {

	List<Restaurant> getEntities();

	List<Restaurant> getEntitiesByCategory(CategoryRestaurant categoryRestaurant);

	List<Restaurant> getEntitiesByComputation(ComputationVote computationVote);

}