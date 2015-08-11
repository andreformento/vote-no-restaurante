package br.com.formento.voteNoRestaurante.service.factory;

import br.com.formento.voteNoRestaurante.model.ComputationVote;

public class ComputationVoteDirector implements Director<ComputationVote> {
	private ComputationVoteBuilder builder;

	public ComputationVoteDirector(ComputationVoteBuilder builder) {
		this.builder = builder;
	}

	public void createInstance() {
		builder.buildDateCreate();
		builder.buildUserVoter();
		builder.buildVoteList();
	}

	public ComputationVote getInstance() {
		return builder.getInstance();
	}
}