package br.com.formento.voteNoRestaurante.service.observer;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Vote;
import br.com.formento.voteNoRestaurante.service.VoteService;

public class ComputationVoteObserverRepositoryVote extends ComputationVoteObserverImpl {

	private VoteService service;

	public ComputationVoteObserverRepositoryVote(ComputationVoteSubject computationVoteSubject, VoteService service) {
		super(computationVoteSubject);
	}

	@Override
	public void update() {
		ComputationVote computationVote = computationVoteSubject.getState();

		for (Vote vote : computationVote.getVoteList()) {
			vote.setComputationVote(computationVote);
			service.createEntity(vote);
		}
	}

}
