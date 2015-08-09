package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;

@Transactional
@Repository
public class CategoryRestaurantRepositoryImpl extends AbstractRepository<CategoryRestaurant> implements CategoryRestaurantRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryRestaurant> getEntities() {
		// TODO ordenar lista por descrição
//		List<?> find = getHibernateTemplate().find("from CategoryRestaurant cr order by cr.description");
//		return (List<CategoryRestaurant>)find;
		
		return super.getEntities();
	}

}