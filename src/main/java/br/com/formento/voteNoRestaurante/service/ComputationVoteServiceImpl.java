package br.com.formento.voteNoRestaurante.service;

import java.util.Date;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.UserVoter;
import br.com.formento.voteNoRestaurante.model.Vote;
import br.com.formento.voteNoRestaurante.repositories.ComputationVoteRepository;
import br.com.formento.voteNoRestaurante.repositories.Repository;

@Service
public class ComputationVoteServiceImpl extends AbstractEntityService<ComputationVote> implements ComputationVoteService {

	@Autowired
	private ComputationVoteRepository repository;

	@Autowired
	private UserVoterService userVoterService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private MailService mailService;

	@Autowired
	private MessageSource messageSource;

	@Override
	protected Repository<ComputationVote> getRepository() {
		return repository;
	}

	// TODO colocar na lista de processamento para computador o voto e enviar o email
	@Override
	@Transactional
	public void computingVote(ComputationVote computationVote) {
		// TODO aplicar pattern
		UserVoter userVoterByEmail = userVoterService.getByEmail(computationVote.getUserVoter().getEmail());
		if (userVoterByEmail == null) {
			UserVoter userVoter = computationVote.getUserVoter();
			userVoterService.save(userVoter);
		} else
			computationVote.setUserVoter(userVoterByEmail);

		computationVote.setDateCreate(new Date());
		computationVote = repository.save(computationVote);

		for (Vote vote : computationVote.getVoteList()) {
			vote.setComputationVote(computationVote);
			voteService.createEntity(vote);
		}

		// TODO usar um pattern para envio de email
		Locale l = new Locale("pt", "BR");
		String subject = messageSource.getMessage("email.subject", null,l);
		System.out.println(subject);
		String body = "<strong>corpo</strong> do email";
		mailService.sendMail(computationVote.getUserVoter().getEmail(), subject, body);
	}

}