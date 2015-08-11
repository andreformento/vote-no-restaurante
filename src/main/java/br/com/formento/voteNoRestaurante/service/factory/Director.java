package br.com.formento.voteNoRestaurante.service.factory;

public interface Director<T> {
	void createInstance();

	T getInstance();
}
