package br.com.formento.voteNoRestaurante.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.InitializationCache;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.RestaurantIcon;
import br.com.formento.voteNoRestaurante.service.CategoryRestaurantService;
import br.com.formento.voteNoRestaurante.service.RestaurantIconService;
import br.com.formento.voteNoRestaurante.service.RestaurantService;
import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheBuilder;
import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheDirector;

@Service
public class InitializationCacheFacadeImpl implements InitializationCacheFacade {

	@Autowired
	private CategoryRestaurantService categoryRestaurantService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private RestaurantIconService restaurantIconService;

	private InitializationCache initializationCache;

	@Override
	public void buildLists(InitializationCacheBuilder initializationCacheBuilder) {
		InitializationCacheDirector director = new InitializationCacheDirector(initializationCacheBuilder);
		director.createInstance();
		initializationCache = director.getInstance();
	}

	@Override
	public void saveListCategoryRestaurant() {
		for (CategoryRestaurant entity : initializationCache.getListCategoryRestaurant())
			categoryRestaurantService.createEntity(entity);
	}

	@Override
	public void saveListRestaurant() {
		for (Restaurant entity : initializationCache.getListRestaurant())
			restaurantService.createEntity(entity);
	}

	@Override
	public void saveListRestaurantIcon() {
		for (RestaurantIcon entity : initializationCache.getListRestaurantIcon())
			restaurantIconService.createEntity(entity);
	}

}
