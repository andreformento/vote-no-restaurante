package br.com.formento.voteNoRestaurante.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		sql.append(" where cr.id = :categoryRestaurantId ");
		sql.append(" order by r.description");

		Map<String, Object> params = new HashMap<>();
		params.put("categoryRestaurantId", categoryRestaurant.getId());

		List<Restaurant> list = simpleQueryList(sql.toString(), params);
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
		sql.append("   and cv.id = :computationVoteId ");
		sql.append(" order by r.description");

		Map<String, Object> params = new HashMap<>();
		params.put("computationVoteId", computationVote.getId());

		List<Restaurant> list = simpleQueryList(sql.toString(), params);
		return list;
	}

}