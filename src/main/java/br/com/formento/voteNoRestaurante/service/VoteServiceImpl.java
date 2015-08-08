package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.formento.voteNoRestaurante.model.Vote;
import br.com.formento.voteNoRestaurante.repositories.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository repository;

	@Override
	public List<Vote> getEntities() {
		return this.repository.getEntities();
	}

	@Override
	@Transactional
	public void createEntity(Vote entity) {
		this.repository.save(entity);
	}

}