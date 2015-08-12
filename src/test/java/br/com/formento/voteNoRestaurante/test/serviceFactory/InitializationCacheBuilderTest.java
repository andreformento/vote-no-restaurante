package br.com.formento.voteNoRestaurante.test.serviceFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.formento.voteNoRestaurante.model.InitializationCache;
import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheBuilder;
import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheBuilderImpl;
import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheDirector;

public class InitializationCacheBuilderTest {

	@Test
	public void testInitializationCacheBuilderImpl() {
		InitializationCacheBuilder initializationCacheBuilder = new InitializationCacheBuilderImpl();
		InitializationCacheDirector director = new InitializationCacheDirector(initializationCacheBuilder);
		director.createInstance();
		InitializationCache initializationCache = director.getInstance();

		assertNotNull(initializationCache);

		assertNotNull(initializationCache.getListCategoryRestaurant());
		assertFalse(initializationCache.getListCategoryRestaurant().isEmpty());

		assertNotNull(initializationCache.getListRestaurant());
		assertFalse(initializationCache.getListRestaurant().isEmpty());

		assertNotNull(initializationCache.getListRestaurantIcon());
		assertFalse(initializationCache.getListRestaurantIcon().isEmpty());
	}

}
