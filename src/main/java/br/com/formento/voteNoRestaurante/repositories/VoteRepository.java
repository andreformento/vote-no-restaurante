package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Vote;

public interface VoteRepository {

	List<Vote> getEntities();

	Long save(Vote entity);

}