package br.com.formento.voteNoRestaurante.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.RestaurantIcon;

@Transactional
@Repository
public class RestaurantIconRepositoryImpl extends AbstractRepository<RestaurantIcon> implements RestaurantIconRepository {

	@Autowired
	public RestaurantIconRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}