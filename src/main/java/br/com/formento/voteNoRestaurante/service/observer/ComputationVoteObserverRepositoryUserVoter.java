package br.com.formento.voteNoRestaurante.service.observer;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.UserVoter;
import br.com.formento.voteNoRestaurante.service.UserVoterService;

public class ComputationVoteObserverRepositoryUserVoter extends ComputationVoteObserverImpl {

	private UserVoterService service;

	public ComputationVoteObserverRepositoryUserVoter(ComputationVoteSubject computationVoteSubject, UserVoterService service) {
		super(computationVoteSubject);
		this.service = service;
	}

	@Override
	public void update() {
		ComputationVote computationVote = computationVoteSubject.getState();

		UserVoter userVoterByEmail = service.getByEmail(computationVote.getUserVoter().getEmail());
		if (userVoterByEmail == null) {
			UserVoter userVoter = computationVote.getUserVoter();
			service.save(userVoter);
		} else
			computationVote.setUserVoter(userVoterByEmail);

	}

}
