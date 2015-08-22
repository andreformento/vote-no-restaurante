package br.com.formento.voteNoRestaurante.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.ComputationVote;

@Transactional
@Repository
public class ComputationVoteRepositoryImpl extends AbstractRepository<ComputationVote> implements ComputationVoteRepository {

	@Autowired
	public ComputationVoteRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}