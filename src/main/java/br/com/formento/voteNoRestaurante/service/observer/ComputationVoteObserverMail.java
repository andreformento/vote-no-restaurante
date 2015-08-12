package br.com.formento.voteNoRestaurante.service.observer;

import br.com.formento.voteNoRestaurante.service.template.EmailTemplate;

public class ComputationVoteObserverMail extends ComputationVoteObserverImpl {

	private EmailTemplate emailTemplate;

	public ComputationVoteObserverMail(ComputationVoteSubject computationVoteSubject, EmailTemplate emailTemplate) {
		super(computationVoteSubject);
		this.emailTemplate = emailTemplate;
	}

	@Override
	public void update() {
		emailTemplate.send();
	}

}
