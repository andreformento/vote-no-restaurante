package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
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

}