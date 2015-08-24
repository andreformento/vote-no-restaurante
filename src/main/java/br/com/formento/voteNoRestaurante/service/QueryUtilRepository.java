package br.com.formento.voteNoRestaurante.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import br.com.formento.voteNoRestaurante.repository.Repository;

public class QueryUtilRepository<T> implements Repository<T> {

	private EntityManager entityManager;

	private final Class<T> entityClass;

	public QueryUtilRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		entityClass = generateEntityClass();
	}

	/**
	 * Gera a classe da entidade correspondente
	 */
	@SuppressWarnings("unchecked")
	private Class<T> generateEntityClass() {
		Class<?> thisClass = getClass();
		ParameterizedType parameterizedType = (ParameterizedType) thisClass.getGenericSuperclass();

		Type type = parameterizedType.getActualTypeArguments()[0];
		return (Class<T>) type;
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


	public Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	@Transactional
	public T save(T entity) {
		entityManager.persist(entity);

		return entity;
	}

	@Override
	@Transactional
	public T merge(T entity) {
		entityManager.merge(entity);

		return entity;
	}

	@Override
	public T byId(Long id) {
		T entity = entityManager.find(entityClass, id);
		return entity;
	}

	public List<T> getEntities() {
		CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(entityClass);
		criteria.select(criteria.from(entityClass));
		List<T> ListOfEmailDomains = entityManager.createQuery(criteria).getResultList();
		return ListOfEmailDomains;
	}

}
