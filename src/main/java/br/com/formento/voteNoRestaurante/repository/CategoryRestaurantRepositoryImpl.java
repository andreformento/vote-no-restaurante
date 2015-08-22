package br.com.formento.voteNoRestaurante.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;

@Transactional
@Repository
public class CategoryRestaurantRepositoryImpl extends AbstractRepository<CategoryRestaurant> implements CategoryRestaurantRepository {

	@Override
	public List<CategoryRestaurant> getEntities() {
		StringBuilder sql = new StringBuilder();
		sql.append(" from CategoryRestaurant cr");
		sql.append(" order by cr.exhibitionOrder");

		Map<String, Object> params = new HashMap<>();

		List<CategoryRestaurant> list = getQueryUtilRepository().simpleQueryList(sql.toString(), params);
		return list;
	}

	@Override
	public CategoryRestaurant getNextByOrder(int order) {
		StringBuilder sql = new StringBuilder();
		sql.append(" from CategoryRestaurant cr");
		sql.append(" where cr.exhibitionOrder > :order ");
		sql.append(" order by cr.exhibitionOrder");

		Map<String, Object> params = new HashMap<>();
		params.put("order", order);

		List<CategoryRestaurant> list = getQueryUtilRepository().simpleQueryList(sql.toString(), params);

		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

}