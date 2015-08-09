package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Vote;

public interface VoteRepository extends Repository<Vote> {

	List<Vote> getEntities();

}