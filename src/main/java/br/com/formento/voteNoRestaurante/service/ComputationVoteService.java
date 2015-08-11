package br.com.formento.voteNoRestaurante.service;

import br.com.formento.voteNoRestaurante.model.ComputationVote;

public interface ComputationVoteService extends EntityService<ComputationVote> {

	void computingVote(ComputationVote computationVote);

}