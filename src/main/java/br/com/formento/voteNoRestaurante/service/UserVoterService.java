package br.com.formento.voteNoRestaurante.service;

import br.com.formento.voteNoRestaurante.model.UserVoter;

public interface UserVoterService extends EntityService<UserVoter> {

	UserVoter getByEmail(String email);

	UserVoter save(UserVoter UserVoter);

}