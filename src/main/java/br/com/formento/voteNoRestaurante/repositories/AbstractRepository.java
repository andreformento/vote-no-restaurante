package br.com.formento.voteNoRestaurante.repositories;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import br.com.formento.voteNoRestaurante.model.ModelEntity;

/**
 * TODO aplicar pattern buid
 */
public abstract class AbstractRepository<T extends ModelEntity> implements Repository<T> {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	private Class<T> entityClass;

	public AbstractRepository() {
		generateEntityClass();
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
	private void generateEntityClass() {
		Class<?> thisClass = getClass();
		ParameterizedType parameterizedType = (ParameterizedType) thisClass.getGenericSuperclass();

		Type type = parameterizedType.getActualTypeArguments()[0];
		this.entityClass = (Class<T>) type;
	}

	@Override
	public Long save(T entity) {
		T merge = this.hibernateTemplate.merge(entity);
		// this.hibernateTemplate.flush();
		return merge.getId();
	}

	@Override
	public T byId(Long id) {
		T entity = hibernateTemplate.get(entityClass, id);
		return entity;
	}

	/**
	 * Este método é protected porque deve ser public somente em algumas classes. Nestas, eles deverão ser sobreescritos
	 * 
	 * @return
	 */
	protected List<T> getEntities() {
		return getHibernateTemplate().loadAll(entityClass);
	}

}
