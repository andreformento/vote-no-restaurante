package br.com.formento.voteNoRestaurante.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import br.com.formento.voteNoRestaurante.model.ModelEntity;

/**
 * TODO aplicar pattern build
 */
public abstract class AbstractRepository<T extends ModelEntity> implements Repository<T> {

	private HibernateTemplate hibernateTemplate;

	private final Class<T> entityClass;

	@Autowired
	public AbstractRepository(HibernateTemplate hibernateTemplate) {
		this.entityClass = generateEntityClass();
		this.hibernateTemplate = hibernateTemplate;
	}

	protected HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
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
		this.hibernateTemplate.persist(entity);

		return entity;
	}

	@Override
	@Transactional
	public T merge(T entity) {
		this.hibernateTemplate.merge(entity);

		return entity;
	}

	@Override
	public T byId(Long id) {
		T entity = hibernateTemplate.get(entityClass, id);
		return entity;
	}

	/**
	 * Este método é protected porque deve ser public somente em algumas
	 * classes. Nestas, eles deverão ser sobreescritos
	 * 
	 * @return
	 */
	protected List<T> getEntities() {
		return getHibernateTemplate().loadAll(entityClass);
	}

}