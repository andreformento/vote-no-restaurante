package br.com.formento.voteNoRestaurante.model;

public interface LinkMail {

	void addParameter(String name, Object value);

	String generateFullLink();

}