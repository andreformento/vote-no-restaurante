package br.com.formento.voteNoRestaurante.service.factory;

import br.com.formento.voteNoRestaurante.model.ComputationVote;

public abstract class ComputationVoteBuilder implements Builder<ComputationVote> {

	private ComputationVote instance;

	public ComputationVoteBuilder() {
		this.instance = new ComputationVote();
	}

	protected abstract void buildUserVoter();

	protected abstract void buildVoteList();

	protected abstract void buildDateCreate();

	@Override
	public ComputationVote getInstance() {
		return instance;
	}

}
