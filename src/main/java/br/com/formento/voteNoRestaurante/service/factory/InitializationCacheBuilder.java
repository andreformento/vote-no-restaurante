package br.com.formento.voteNoRestaurante.service.factory;

import br.com.formento.voteNoRestaurante.model.InitializationCache;

public abstract class InitializationCacheBuilder implements Builder<InitializationCache> {

	private InitializationCache instance;

	public InitializationCacheBuilder() {
		this.instance = new InitializationCache();
	}

	protected abstract void buildListRestaurant();

	protected abstract void buildListRestaurantIcon();

	protected abstract void buildListCategoryRestaurant();

	@Override
	public InitializationCache getInstance() {
		return instance;
	}

}
