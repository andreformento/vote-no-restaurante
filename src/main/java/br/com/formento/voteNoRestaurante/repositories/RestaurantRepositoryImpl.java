package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.Restaurant;

@Transactional
@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Restaurant> getEntities() {
		return hibernateTemplate.loadAll(Restaurant.class);
	}

	@Override
	public Long save(Restaurant vote) {
		Restaurant mergeRestaurant = this.hibernateTemplate.merge(vote);
		return mergeRestaurant.getId();
	}

}