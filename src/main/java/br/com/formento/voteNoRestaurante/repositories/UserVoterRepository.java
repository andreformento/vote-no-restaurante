package br.com.formento.voteNoRestaurante.repositories;

import br.com.formento.voteNoRestaurante.model.UserVoter;

public interface UserVoterRepository extends Repository<UserVoter> {
	UserVoter getByEmail(String email);
}