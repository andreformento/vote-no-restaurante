package br.com.formento.voteNoRestaurante.service.facade;

import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheBuilder;

public interface InitializationCacheFacade {

	void buildLists(InitializationCacheBuilder initializationCacheBuilder);

	void saveListCategoryRestaurant();

	void saveListRestaurant();

	void saveListRestaurantIcon();

}
