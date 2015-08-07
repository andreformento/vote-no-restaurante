package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Vote;

public interface VoteService {

	List<Vote> getAllVotes();

	void createVote(Vote vote);

}