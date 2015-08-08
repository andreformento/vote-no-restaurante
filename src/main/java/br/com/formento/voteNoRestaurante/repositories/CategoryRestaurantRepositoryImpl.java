package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;

@Transactional
@Repository
public class CategoryRestaurantRepositoryImpl implements CategoryRestaurantRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<CategoryRestaurant> getEntities() {
		return hibernateTemplate.loadAll(CategoryRestaurant.class);
	}

	@Override
	public Long save(CategoryRestaurant entity) {
		CategoryRestaurant merge = this.hibernateTemplate.merge(entity);
		return merge.getId();
	}

}