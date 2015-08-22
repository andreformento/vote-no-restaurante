package br.com.formento.voteNoRestaurante.service.observer;

import java.util.Date;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.repository.ComputationVoteRepository;

public class ComputationVoteObserverRepositoryEntity extends ComputationVoteObserverImpl {

	private ComputationVoteRepository repository;

	public ComputationVoteObserverRepositoryEntity(ComputationVoteSubject computationVoteSubject, ComputationVoteRepository repository) {
		super(computationVoteSubject);
		this.repository = repository;
	}

	@Override
	public void update() {
		ComputationVote computationVote = computationVoteSubject.getState();
		computationVote.setDateCreate(new Date());
		repository.save(computationVote);
	}

}
