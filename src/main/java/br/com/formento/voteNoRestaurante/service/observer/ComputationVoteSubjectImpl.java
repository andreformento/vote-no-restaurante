package br.com.formento.voteNoRestaurante.service.observer;

import java.util.ArrayList;
import java.util.List;
import br.com.formento.voteNoRestaurante.model.ComputationVote;

public class ComputationVoteSubjectImpl implements ComputationVoteSubject {

	protected List<ComputationVoteObserver> observers;
	protected ComputationVote computationVote;

	public ComputationVoteSubjectImpl() {
		observers = new ArrayList<ComputationVoteObserver>();
	}

	@Override
	public void attach(ComputationVoteObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(int indice) {
		observers.remove(indice);
	}

	@Override
	public void setState(ComputationVote computationVote) {
		this.computationVote = computationVote;
		notifyObservers();
	}

	private void notifyObservers() {
		for (ComputationVoteObserver observer : observers)
			observer.update();
	}

	@Override
	public ComputationVote getState() {
		return computationVote;
	}

}
