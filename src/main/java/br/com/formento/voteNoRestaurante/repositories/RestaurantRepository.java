package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Restaurant;

public interface RestaurantRepository extends Repository<Restaurant> {

	List<Restaurant> getEntities();

}