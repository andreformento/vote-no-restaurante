package br.com.formento.voteNoRestaurante.service.observer;

public abstract class ComputationVoteObserverImpl implements ComputationVoteObserver {

	protected ComputationVoteSubject computationVoteSubject;

	public ComputationVoteObserverImpl(ComputationVoteSubject computationVoteSubject) {
		this.computationVoteSubject = computationVoteSubject;
	}

	@Override
	public abstract void update();

}