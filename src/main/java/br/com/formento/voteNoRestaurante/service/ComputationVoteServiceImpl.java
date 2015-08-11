package br.com.formento.voteNoRestaurante.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.repositories.ComputationVoteRepository;
import br.com.formento.voteNoRestaurante.repositories.Repository;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserver;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverMail;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverRepositoryEntity;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverRepositoryUserVoter;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverRepositoryVote;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteSubject;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteSubjectImpl;

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

	// colocar na lista de processamento para computador o voto e enviar o
	// email
	@Override
	@Transactional
	public void computingVote(ComputationVote computationVote) {
		// pattern observer para disparar tudo que for necessario para computar
		// o voto: gravar no banco, mandar email...
		ComputationVoteSubject computationVoteSubject = new ComputationVoteSubjectImpl();

		ComputationVoteObserver repositoryUserVoterObserver = new ComputationVoteObserverRepositoryUserVoter(computationVoteSubject, userVoterService);
		ComputationVoteObserver repositoryEntityObserver = new ComputationVoteObserverRepositoryEntity(computationVoteSubject, repository);
		ComputationVoteObserver repositoryVoteObserver = new ComputationVoteObserverRepositoryVote(computationVoteSubject, voteService);
		ComputationVoteObserver mailObserver = new ComputationVoteObserverMail(computationVoteSubject, mailService, messageSource);

		computationVoteSubject.attach(repositoryUserVoterObserver);
		computationVoteSubject.attach(repositoryEntityObserver);
		computationVoteSubject.attach(repositoryVoteObserver);
		computationVoteSubject.attach(mailObserver);

		computationVoteSubject.setState(computationVote);
	}

}