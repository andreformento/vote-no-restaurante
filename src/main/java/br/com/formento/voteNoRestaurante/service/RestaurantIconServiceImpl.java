package br.com.formento.voteNoRestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.RestaurantIcon;
import br.com.formento.voteNoRestaurante.repository.Repository;
import br.com.formento.voteNoRestaurante.repository.RestaurantIconRepository;

@Service
public class RestaurantIconServiceImpl extends AbstractEntityService<RestaurantIcon> implements RestaurantIconService {

	@Autowired
	private RestaurantIconRepository repository;

	@Override
	protected Repository<RestaurantIcon> getRepository() {
		return repository;
	}

}