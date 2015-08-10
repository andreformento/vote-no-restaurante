package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.FormChoiceRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.repositories.CategoryRestaurantRepository;
import br.com.formento.voteNoRestaurante.repositories.Repository;

@Service
public class CategoryRestaurantServiceImpl extends AbstractEntityService<CategoryRestaurant> implements CategoryRestaurantService {

	@Autowired
	private CategoryRestaurantRepository repository;

	@Override
	protected Repository<CategoryRestaurant> getRepository() {
		return repository;
	}

	@Override
	public List<CategoryRestaurant> getEntities() {
		return this.repository.getEntities();
	}

	@Override
	public CategoryRestaurant getNextByOrder(int order) {
		return this.repository.getNextByOrder(order);
	}
	
	// TODO pattern de constructor
	@Override
	public FormChoiceRestaurant getFormChoiceRestaurant(RestaurantService restaurantService, int order) {
		CategoryRestaurant categoryRestaurant = getNextByOrder(order);
		List<Restaurant> restaurantList = restaurantService.getEntitiesByCategory(categoryRestaurant);
		
		FormChoiceRestaurant formChoiceRestaurant = new FormChoiceRestaurant(categoryRestaurant);
		
	}

}