package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.repositories.Repository;
import br.com.formento.voteNoRestaurante.repositories.RestaurantRepository;

@Service
public class RestaurantServiceImpl extends AbstractEntityService<Restaurant> implements RestaurantService {

	@Autowired
	private RestaurantRepository repository;

	@Override
	protected Repository<Restaurant> getRepository() {
		return repository;
	}

	@Override
	public List<Restaurant> getEntities() {
		return this.repository.getEntities();
	}

	@Override
	public List<Restaurant> getEntitiesByCategory(CategoryRestaurant categoryRestaurant) {
		return this.repository.getEntitiesByCategory(categoryRestaurant);
	}

}