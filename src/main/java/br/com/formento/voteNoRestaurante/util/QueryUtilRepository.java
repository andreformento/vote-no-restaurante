package br.com.formento.voteNoRestaurante.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class QueryUtilRepository<T> {

	private final EntityManager entityManager;
	private final Class<T> entityClass;

	public QueryUtilRepository(EntityManager entityManager, Class<T> entityClass) {
		this.entityManager = entityManager;
		this.entityClass = entityClass;
	}

	private TypedQuery<T> generateQuery(String sql, Map<String, Object> params, int maxResults) {
		TypedQuery<T> query = entityManager.createQuery(sql, entityClass);

		for (Entry<String, Object> param : params.entrySet())
			query.setParameter(param.getKey(), param.getValue());

		if (maxResults > 0)
			query.setMaxResults(maxResults);

		return query;
	}

	public List<T> simpleQueryList(String sql, Map<String, Object> params, int maxResults) {
		List<T> result = generateQuery(sql, params, maxResults).getResultList();
		return result;
	}

	public List<T> simpleQueryList(String sql, Map<String, Object> params) {
		return simpleQueryList(sql, params, 0);
	}

	public T simpleQueryUniqueResult(String sql, Map<String, Object> params) {
		TypedQuery<T> generateQuery = generateQuery(sql, params, 0);

		try {
			T result = generateQuery.getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

}
