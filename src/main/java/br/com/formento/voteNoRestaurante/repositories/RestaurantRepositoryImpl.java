package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Restaurant;

@Transactional
@Repository
public class RestaurantRepositoryImpl extends AbstractRepository<Restaurant> implements RestaurantRepository {

	@Override
	public List<Restaurant> getEntities() {
		return super.getEntities();
	}

	@Override
	public List<Restaurant> getEntitiesByCategory(CategoryRestaurant categoryRestaurant) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select r");
		sql.append(" from Restaurant r");
		sql.append(" join r.categoryRestaurant cr");
		sql.append(" where cr.id = ? ");
		sql.append(" order by r.description");

		List<?> find = getHibernateTemplate().find(sql.toString(), categoryRestaurant.getId());
		@SuppressWarnings("unchecked")
		List<Restaurant> list = (List<Restaurant>) find;
		return list;
	}

	@Override
	public List<Restaurant> getEntitiesByComputation(ComputationVote computationVote) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select r");
		sql.append("   from Vote v");
		sql.append(" join v.computationVote cv");
		sql.append(" join v.restaurant r");
		sql.append(" where cv.confirmationDate is not null ");
		sql.append("   and cv.id = ? ");
		sql.append(" order by r.description");

		List<?> find = getHibernateTemplate().find(sql.toString(), computationVote.getId());
		@SuppressWarnings("unchecked")
		List<Restaurant> list = (List<Restaurant>) find;
		return list;
	}

}