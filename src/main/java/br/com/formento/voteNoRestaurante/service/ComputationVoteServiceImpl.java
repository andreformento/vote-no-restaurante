package br.com.formento.voteNoRestaurante.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Ranking;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.repository.ComputationVoteRepository;
import br.com.formento.voteNoRestaurante.repository.Repository;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserver;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverMail;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverRepositoryEntity;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverRepositoryUserVoter;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteObserverRepositoryVote;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteSubject;
import br.com.formento.voteNoRestaurante.service.observer.ComputationVoteSubjectImpl;
import br.com.formento.voteNoRestaurante.service.template.EmailConfirmationVote;
import br.com.formento.voteNoRestaurante.service.template.EmailTemplate;

@Service
public class ComputationVoteServiceImpl extends AbstractEntityService<ComputationVote> implements ComputationVoteService {

	@Autowired
	private ComputationVoteRepository repository;

	@Autowired
	private UserVoterService userVoterService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private MailService mailService;

	@Autowired
	private MessageSource messageSource;

	@Override
	protected Repository<ComputationVote> getRepository() {
		return repository;
	}

	/**
	 * coloca na lista de processamento para computador o voto e enviar o email
	 */
	@Override
	@Transactional
	public void computingVote(ComputationVote computationVote, String urlBase) {
		EmailTemplate emailTemplate = new EmailConfirmationVote(mailService, messageSource, computationVote, urlBase);

		// pattern observer para disparar tudo que for necessario para computar
		// o voto: gravar no banco, mandar email...
		ComputationVoteSubject computationVoteSubject = new ComputationVoteSubjectImpl();

		ComputationVoteObserver repositoryUserVoterObserver = new ComputationVoteObserverRepositoryUserVoter(computationVoteSubject, userVoterService);
		ComputationVoteObserver repositoryEntityObserver = new ComputationVoteObserverRepositoryEntity(computationVoteSubject, repository);
		ComputationVoteObserver repositoryVoteObserver = new ComputationVoteObserverRepositoryVote(computationVoteSubject, voteService);

		ComputationVoteObserver mailObserver = new ComputationVoteObserverMail(computationVoteSubject, emailTemplate);

		computationVoteSubject.attach(repositoryUserVoterObserver);
		computationVoteSubject.attach(repositoryEntityObserver);
		computationVoteSubject.attach(repositoryVoteObserver);
		computationVoteSubject.attach(mailObserver);

		computationVoteSubject.setState(computationVote);
	}

	@Override
	public Ranking confirmById(Long id) {
		ComputationVote computationVote = repository.byId(id);
		confirm(computationVote);

		Ranking ranking = generateRanking();

		List<Restaurant> restaurantChoiceList = restaurantService.getEntitiesByComputation(computationVote);
		for (Restaurant restaurant : restaurantChoiceList)
			ranking.setRestaurantChoice(restaurant);

		return ranking;
	}

	@Override
	public void confirm(ComputationVote computationVote) {
		if (computationVote.getConfirmationDate() == null) {
			computationVote.setConfirmationDate(new Date());
			repository.merge(computationVote);
		}
	}

	@Override
	public Ranking generateRanking() {
		Ranking ranking = new Ranking();
		List<Restaurant> entities = restaurantService.getEntities();

		for (Restaurant restaurant : entities) {
			Long amountValidVotesByRestaurant = voteService.getAmountValidVotesByRestaurant(restaurant);
			ranking.addRestaurant(restaurant, amountValidVotesByRestaurant);
		}

		return ranking;
	}

}