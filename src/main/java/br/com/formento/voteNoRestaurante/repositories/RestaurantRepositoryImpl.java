package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.Restaurant;

@Transactional
@Repository
public class RestaurantRepositoryImpl extends AbstractRepository<Restaurant> implements RestaurantRepository {

	@Override
	public List<Restaurant> getEntities() {
		return super.getEntities();
	}

}