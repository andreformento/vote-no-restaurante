package br.com.formento.voteNoRestaurante.service.template;

import br.com.formento.voteNoRestaurante.service.MailService;

public abstract class AbstractEmailTemplate implements EmailTemplate {

	private MailService mailService;

	public AbstractEmailTemplate(MailService mailService) {
		this.mailService = mailService;
	}

	protected abstract String prepareSubject();

	protected abstract String prepareBody();

	protected abstract String prepareTo();

	@Override
	public void send() {
		String subject = prepareSubject();
		String body = prepareBody();
		String to = prepareTo();

		// fazer uma Thread ser disparada para enviar o email
		mailService.sendMail(to, subject, body);
	}

}
