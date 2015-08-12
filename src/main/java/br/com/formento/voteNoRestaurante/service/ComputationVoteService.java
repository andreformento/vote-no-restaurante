package br.com.formento.voteNoRestaurante.service;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Ranking;

public interface ComputationVoteService extends EntityService<ComputationVote> {

	void computingVote(ComputationVote computationVote, String urlBase);

	Ranking confirmById(Long id);

	void confirm(ComputationVote computationVote);

	Ranking generateRanking();

}