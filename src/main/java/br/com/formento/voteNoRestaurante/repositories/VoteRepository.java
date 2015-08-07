package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.formento.voteNoRestaurante.model.Vote;

@Transactional
@Repository("voteRepository")
public class VoteRepository {

	// @Autowired
	// private HibernateTemplate hibernateTemplate;
	//
	// public List<Vote> getAllVotes() {
	// return this.hibernateTemplate.loadAll(Vote.class);
	// }
	//
	// public Long createVote(Vote vote) {
	// Vote mergeVote = this.hibernateTemplate.merge(vote);
	// return mergeVote.getId();
	// }

	// @Autowired
	// protected SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Vote> getEntities() {
		TypedQuery<Vote> query = entityManager.createQuery("select o from br.com.formento.voteNoRestaurante.model.Vote e", Vote.class);
		return query.getResultList();
	}

	public Vote find(Long id) {
		return entityManager.find(Vote.class, id);
	}

	public void save(Vote e) {
		entityManager.persist(e);
	}

}