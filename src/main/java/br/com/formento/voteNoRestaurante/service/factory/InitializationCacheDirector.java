package br.com.formento.voteNoRestaurante.service.factory;

import br.com.formento.voteNoRestaurante.model.InitializationCache;

public class InitializationCacheDirector implements Director<InitializationCache> {
	private InitializationCacheBuilder builder;

	public InitializationCacheDirector(InitializationCacheBuilder builder) {
		this.builder = builder;
	}

	public void createInstance() {
		builder.buildListCategoryRestaurant();
		builder.buildListRestaurant();
		builder.buildListRestaurantIcon();
	}

	public InitializationCache getInstance() {
		return builder.getInstance();
	}
}