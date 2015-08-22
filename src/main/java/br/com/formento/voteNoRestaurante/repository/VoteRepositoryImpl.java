package br.com.formento.voteNoRestaurante.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.Vote;

@Transactional
@Repository
public class VoteRepositoryImpl extends AbstractRepository<Vote> implements VoteRepository {

	@Override
	public List<Vote> getEntities() {
		return super.getEntities();
	}

	@Override
	public Long getAmountValidVotesByRestaurant(Restaurant restaurant) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(v.id)");
		sql.append(" from Vote v");
		sql.append(" join v.computationVote cv");
		sql.append(" join v.restaurant r");
		sql.append(" where cv.confirmationDate is not null ");
		sql.append("   and r.id = :idRestaurant ");

		TypedQuery<Long> query = getEntityManager().createQuery(sql.toString(), Long.class);

		query.setParameter("idRestaurant", restaurant.getId());

		Long result = query.getSingleResult();
		return result;
	}

}