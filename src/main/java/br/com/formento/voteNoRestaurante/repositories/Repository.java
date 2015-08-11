package br.com.formento.voteNoRestaurante.repositories;

public interface Repository<T> {

	T byId(Long id);

	T save(T entity);

}
