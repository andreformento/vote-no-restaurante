package br.com.formento.voteNoRestaurante.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;

import br.com.formento.voteNoRestaurante.model.ModelEntity;
import br.com.formento.voteNoRestaurante.util.QueryUtilRepository;

/**
 * TODO aplicar pattern build
 */
public abstract class AbstractRepository<T extends ModelEntity> implements Repository<T> {

	@PersistenceContext
	private EntityManager entityManager;

	private final Class<T> entityClass;
	private QueryUtilRepository<T> queryUtilRepository;

	public AbstractRepository() {
		this.entityClass = generateEntityClass();
	}

	protected Class<T> getEntityClass() {
		return entityClass;
	}

	protected DetachedCriteria generateDetachedCriteria() {
		return DetachedCriteria.forClass(entityClass);
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

	@Override
	@Transactional
	public T save(T entity) {
		// entity = this.hibernateTemplate.merge(entity);
		this.entityManager.persist(entity);

		return entity;
	}

	@Override
	@Transactional
	public T merge(T entity) {
		this.entityManager.merge(entity);

		return entity;
	}

	@Override
	public T byId(Long id) {
		T entity = entityManager.find(entityClass, id);
		return entity;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Este método é protected porque deve ser public somente em algumas classes. Nestas, eles deverão ser sobreescritos
	 * 
	 * @return
	 */
	protected List<T> getEntities() {
		CriteriaQuery<T> criteria = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		criteria.select(criteria.from(entityClass));
		List<T> ListOfEmailDomains = getEntityManager().createQuery(criteria).getResultList();
		return ListOfEmailDomains;
	}

	protected QueryUtilRepository<T> getQueryUtilRepository() {
		if (queryUtilRepository == null)
			queryUtilRepository = new QueryUtilRepository<T>(entityManager, entityClass);
		return queryUtilRepository;
	}

}
