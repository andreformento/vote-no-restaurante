package br.com.formento.voteNoRestaurante.repository;

public interface Repository<T> {

	T byId(Long id);

	T save(T entity);

	T merge(T entity);

}
