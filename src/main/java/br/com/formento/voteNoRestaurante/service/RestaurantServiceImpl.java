package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.controller.form.FormChoiceRestaurant;
import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.repository.Repository;
import br.com.formento.voteNoRestaurante.repository.RestaurantRepository;
import br.com.formento.voteNoRestaurante.service.factory.FormChoiceRestaurantBuilder;
import br.com.formento.voteNoRestaurante.service.factory.FormChoiceRestaurantBuilderImpl;
import br.com.formento.voteNoRestaurante.service.factory.FormChoiceRestaurantDirector;

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

	@Override
	public FormChoiceRestaurant getFormChoiceRestaurant(CategoryRestaurant categoryRestaurant) {
		List<Restaurant> restaurantList = getEntitiesByCategory(categoryRestaurant);

		FormChoiceRestaurantBuilder builder = new FormChoiceRestaurantBuilderImpl(categoryRestaurant, restaurantList);
		FormChoiceRestaurantDirector director = new FormChoiceRestaurantDirector(builder);
		director.createInstance();

		return director.getInstance();
	}
	
	@Override
	public List<Restaurant> getEntitiesByComputation(ComputationVote computationVote) {
		return repository.getEntitiesByComputation(computationVote);
	}

}