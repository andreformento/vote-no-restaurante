package br.com.formento.voteNoRestaurante.service.observer;

import br.com.formento.voteNoRestaurante.model.ComputationVote;

public interface ComputationVoteSubject {

	void attach(ComputationVoteObserver observer);

	void detach(int indice);

	void setState(ComputationVote computationVote);

	ComputationVote getState();

}
