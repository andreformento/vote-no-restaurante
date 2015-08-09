package br.com.formento.voteNoRestaurante.repositories;

public interface Repository<T> {

	T byId(Long id);

	Long save(T entity);

}
