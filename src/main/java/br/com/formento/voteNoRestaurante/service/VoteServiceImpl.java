package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.Vote;
import br.com.formento.voteNoRestaurante.repositories.Repository;
import br.com.formento.voteNoRestaurante.repositories.VoteRepository;

@Service
public class VoteServiceImpl extends AbstractEntityService<Vote> implements VoteService {

	@Autowired
	private VoteRepository repository;

	@Override
	protected Repository<Vote> getRepository() {
		return repository;
	}

	@Override
	public List<Vote> getEntities() {
		return this.repository.getEntities();
	}

	@Override
	public Long getAmountValidVotesByRestaurant(Restaurant restaurant) {
		return repository.getAmountValidVotesByRestaurant(restaurant);
	}

}