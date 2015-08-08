package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Vote;

public interface VoteService extends EntityService<Vote> {

	List<Vote> getEntities();

}