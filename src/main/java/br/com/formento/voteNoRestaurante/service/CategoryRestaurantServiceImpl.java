package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.repositories.CategoryRestaurantRepository;

@Service
public class CategoryRestaurantServiceImpl implements CategoryRestaurantService {

	@Autowired
	private CategoryRestaurantRepository repository;

	@Override
	public List<CategoryRestaurant> getEntities() {
		return this.repository.getEntities();
	}

	@Override
	@Transactional
	public void createEntity(CategoryRestaurant entity) {
		this.repository.save(entity);
	}

}