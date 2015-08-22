package br.com.formento.voteNoRestaurante.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.repository.CategoryRestaurantRepository;
import br.com.formento.voteNoRestaurante.repository.Repository;
import br.com.formento.voteNoRestaurante.repository.RestaurantRepository;
import br.com.formento.voteNoRestaurante.service.factory.ComputationVoteBuilder;
import br.com.formento.voteNoRestaurante.service.factory.ComputationVoteBuilderImpl;
import br.com.formento.voteNoRestaurante.service.factory.ComputationVoteDirector;

@Service
public class CategoryRestaurantServiceImpl extends AbstractEntityService<CategoryRestaurant> implements CategoryRestaurantService {

	@Autowired
	private CategoryRestaurantRepository repository;

	@Autowired
	private RestaurantRepository restaurantRepository;

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

	@Override
	public ComputationVote getComputationVote(List<Long> idRestaurantList) {
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		for (Long idRestaurant : idRestaurantList)
			restaurantList.add(restaurantRepository.byId(idRestaurant));

		ComputationVoteBuilder builder = new ComputationVoteBuilderImpl(restaurantList);
		ComputationVoteDirector director = new ComputationVoteDirector(builder);
		director.createInstance();

		return director.getInstance();
	}

}