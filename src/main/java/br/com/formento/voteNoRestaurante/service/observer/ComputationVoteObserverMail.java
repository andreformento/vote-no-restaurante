package br.com.formento.voteNoRestaurante.service.observer;

import java.util.Locale;

import org.springframework.context.MessageSource;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.service.MailService;

public class ComputationVoteObserverMail extends ComputationVoteObserverImpl {

	private MailService mailService;
	private MessageSource messageSource;

	public ComputationVoteObserverMail(ComputationVoteSubject computationVoteSubject, MailService mailService, MessageSource messageSource) {
		super(computationVoteSubject);
		this.mailService = mailService;
		this.messageSource = messageSource;
	}

	@Override
	public void update() {
		ComputationVote computationVote = computationVoteSubject.getState();
		// TODO usar um pattern para envio de email
		Locale l = new Locale("pt", "BR");
		String subject = messageSource.getMessage("email.subject", null, l);
		System.out.println(subject);
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("<strong>corpo</strong> do email");
		
		mailService.sendMail(computationVote.getUserVoter().getEmail(), subject, mensagem.toString());
	}

}
