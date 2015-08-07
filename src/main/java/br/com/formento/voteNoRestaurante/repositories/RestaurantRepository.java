package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Restaurant;

public interface RestaurantRepository {

	List<Restaurant> getEntities();

	Long save(Restaurant restaurant);

}