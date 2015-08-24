package br.com.formento.voteNoRestaurante.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.formento.voteNoRestaurante.model.ModelEntity;
import br.com.formento.voteNoRestaurante.service.QueryUtilRepository;

/**
 * TODO aplicar pattern build
 */
public abstract class AbstractRepository<T extends ModelEntity> implements Repository<T> {

	@PersistenceContext
	private EntityManager entityManager;

	private QueryUtilRepository<T> queryUtilRepository;

	public AbstractRepository() {
	}

	public AbstractRepository(QueryUtilRepository<T> queryUtilRepository) {
		this.queryUtilRepository = queryUtilRepository;
	}

	@Override
	@Transactional
	public T save(T entity) {
		return getQueryUtilRepository().save(entity);
	}

	@Override
	@Transactional
	public T merge(T entity) {
		return getQueryUtilRepository().merge(entity);
	}

	@Override
	public T byId(Long id) {
		return getQueryUtilRepository().byId(id);
	}

	private QueryUtilRepository<T> getQueryUtilRepository() {
		if (queryUtilRepository == null)
			queryUtilRepository = new QueryUtilRepository<>(entityManager);
		return queryUtilRepository;
	}

	public List<T> simpleQueryList(String sql, Map<String, Object> params, int maxResults) {
		return getQueryUtilRepository().simpleQueryList(sql, params, maxResults);
	}

	public List<T> simpleQueryList(String sql, Map<String, Object> params) {
		return getQueryUtilRepository().simpleQueryList(sql, params);
	}

	public T simpleQueryUniqueResult(String sql, Map<String, Object> params) {
		return getQueryUtilRepository().simpleQueryUniqueResult(sql, params);
	}

	/**
	 * Este método é protected porque deve ser public somente em algumas classes. Nestas, eles deverão ser sobreescritos
	 * 
	 * @return
	 */
	protected List<T> getEntities() {
		return getQueryUtilRepository().getEntities();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
