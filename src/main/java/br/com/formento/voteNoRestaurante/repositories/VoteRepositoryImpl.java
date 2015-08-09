package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.Vote;

@Transactional
@Repository
public class VoteRepositoryImpl extends AbstractRepository<Vote> implements VoteRepository {

	@Override
	public List<Vote> getEntities() {
		return super.getEntities();
	}

//	@Autowired
//	protected SessionFactory sessionFactory;
//
//	public List<Vote> getEntities() {
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		Criteria createCriteria = currentSession.createCriteria(Vote.class);
//		
//		TypedQuery<Vote> query = entityManager.createQuery("select o from br.com.formento.voteNoRestaurante.model.Vote e", Vote.class);
//		return query.getResultList();
//	}
//
//	public Vote find(Long id) {
//		return entityManager.find(Vote.class, id);
//	}
//
//	public void save(Vote e) {
//		entityManager.persist(e);
//	}
	

	// // @PersistenceContext
//	private EntityManager entityManager;
//
//	public List<Vote> getEntities() {
//		TypedQuery<Vote> query = entityManager.createQuery("select o from br.com.formento.voteNoRestaurante.model.Vote e", Vote.class);
//		return query.getResultList();
//	}
//
//	public Vote find(Long id) {
//		return entityManager.find(Vote.class, id);
//	}
//
//	public void save(Vote e) {
//		entityManager.persist(e);
//	}

}