package br.com.formento.voteNoRestaurante.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.formento.voteNoRestaurante.service.facade.InitializationCacheFacadeImpl;
import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheBuilder;
import br.com.formento.voteNoRestaurante.service.factory.InitializationCacheBuilderImpl;

@SpringBootApplication
public class ApplicationCache {

	@Autowired
	private InitializationCacheFacadeImpl initializationCacheFacadeImpl;

	@PostConstruct
	public void populateRestaurant() {
		InitializationCacheBuilder initializationCacheBuilder = new InitializationCacheBuilderImpl();
		initializationCacheFacadeImpl.buildLists(initializationCacheBuilder);
		initializationCacheFacadeImpl.saveListCategoryRestaurant();
		initializationCacheFacadeImpl.saveListRestaurant();
		initializationCacheFacadeImpl.saveListRestaurantIcon();
	}

}