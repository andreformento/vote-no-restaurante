package br.com.formento.voteNoRestaurante.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formento.voteNoRestaurante.model.UserVoter;
import br.com.formento.voteNoRestaurante.repository.Repository;
import br.com.formento.voteNoRestaurante.repository.UserVoterRepository;

@Service
public class UserVoterServiceImpl extends AbstractEntityService<UserVoter> implements UserVoterService {

	@Autowired
	private UserVoterRepository repository;

	@Override
	protected Repository<UserVoter> getRepository() {
		return repository;
	}

	@Override
	@Transactional
	public UserVoter save(UserVoter entity) {
		return repository.save(entity);
	}

	@Override
	public UserVoter getByEmail(String email) {
		return repository.getByEmail(email);
	}

}