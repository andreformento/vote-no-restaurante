package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.Vote;

@Transactional
@Repository
public class VoteRepositoryImpl implements VoteRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Vote> getEntities() {
		return hibernateTemplate.loadAll(Vote.class);
	}

	@Override
	public Long save(Vote entity) {
		Vote merge = this.hibernateTemplate.merge(entity);
		return merge.getId();
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