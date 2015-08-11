package br.com.formento.voteNoRestaurante.repositories;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.ComputationVote;

@Transactional
@Repository
public class ComputationVoteRepositoryImpl extends AbstractRepository<ComputationVote> implements ComputationVoteRepository {

}