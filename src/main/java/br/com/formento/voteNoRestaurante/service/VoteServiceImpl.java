package br.com.formento.voteNoRestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.formento.voteNoRestaurante.model.Vote;
import br.com.formento.voteNoRestaurante.repositories.VoteRepository;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

//	@Autowired
	VoteRepository voteRepository;

	@Override
	public List<Vote> getAllVotes() {
		return this.voteRepository.getEntities();
	}

	@Override
	@Transactional
	public void createVote(Vote vote) {
		this.voteRepository.save(vote);
	}

}