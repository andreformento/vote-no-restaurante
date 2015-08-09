package br.com.formento.voteNoRestaurante.service;

import org.springframework.transaction.annotation.Transactional;

import br.com.formento.voteNoRestaurante.repositories.Repository;

public abstract class AbstractEntityService<T> implements EntityService<T> {

	protected abstract Repository<T> getRepository();

	@Override
	@Transactional
	public void createEntity(T entity) {
		this.getRepository().save(entity);
	}

	@Override
	@Transactional
	public T getEntityById(Long id) {
		return this.getRepository().byId(id);
	}

}
