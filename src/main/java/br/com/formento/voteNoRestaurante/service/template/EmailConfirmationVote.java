package br.com.formento.voteNoRestaurante.service.template;

import java.util.Locale;

import org.springframework.context.MessageSource;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.LinkMail;
import br.com.formento.voteNoRestaurante.model.LinkMailImpl;
import br.com.formento.voteNoRestaurante.service.MailService;

public class EmailConfirmationVote extends AbstractEmailTemplate {

	private ComputationVote computationVote;
	private MessageSource messageSource;
	private Locale locale;
	private String urlBase;

	public EmailConfirmationVote(MailService mailService, MessageSource messageSource, ComputationVote computationVote, String urlBase) {
		super(mailService);
		this.messageSource = messageSource;
		this.computationVote = computationVote;
		this.urlBase = urlBase;

		this.locale = new Locale("pt", "BR");
	}

	private String getMensagem(String code) {
		return messageSource.getMessage(code, null, this.locale);
	}

	@Override
	protected String prepareSubject() {
		return getMensagem("email.confirmationVote.subject");
	}

	@Override
	protected String prepareBody() {
		StringBuilder mensagem = new StringBuilder();

		mensagem.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' ");
		mensagem.append("	'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
		mensagem.append("<html xmlns='http://www.w3.org/1999/xhtml'>");
		mensagem.append("	<head><meta http-equiv='Content-Type'");
		mensagem.append("			content='text/html; charset=UTF-8' /></head>");
		mensagem.append("    <body>");

		mensagem.append("		<h2>");
		mensagem.append(getMensagem("email.confirmationVote.subject"));
		mensagem.append("		</h2>");

		mensagem.append("		<h3>");
		mensagem.append(computationVote.getUserVoter().getName());
		mensagem.append(",		</h3>");

		mensagem.append("		<h3>");
		mensagem.append(getMensagem("email.confirmationVote.thankYou"));
		mensagem.append("		</h3>");

		mensagem.append("		<p>");
		mensagem.append(getMensagem("email.confirmationVote.confirm"));
		mensagem.append(":		</p>");

		mensagem.append("		<div>");

		mensagem.append("			<a href='");

		LinkMail linkMail = new LinkMailImpl(urlBase, "vote/confirm");
		linkMail.addParameter("id", computationVote.getId());
		String link = linkMail.generateFullLink();

		mensagem.append(link);
		mensagem.append("' target='_blank'>");

		mensagem.append(link);
		mensagem.append("			</a>");

		mensagem.append("		</div>");
		mensagem.append("    </body>");
		mensagem.append("</html>");

		return mensagem.toString();
	}

	@Override
	protected String prepareTo() {
		return computationVote.getUserVoter().getEmail();
	}

}
