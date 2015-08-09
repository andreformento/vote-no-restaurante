package br.com.formento.voteNoRestaurante.service;

public interface EntityService<T> {

	void createEntity(T entity);

	T getEntityById(Long id);

}
