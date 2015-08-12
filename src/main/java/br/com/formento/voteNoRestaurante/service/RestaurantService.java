package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.controller.form.FormChoiceRestaurant;
import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Restaurant;

public interface RestaurantService extends EntityService<Restaurant> {

	List<Restaurant> getEntities();

	List<Restaurant> getEntitiesByCategory(CategoryRestaurant categoryRestaurant);

	FormChoiceRestaurant getFormChoiceRestaurant(CategoryRestaurant categoryRestaurant);

	List<Restaurant> getEntitiesByComputation(ComputationVote computationVote);

}