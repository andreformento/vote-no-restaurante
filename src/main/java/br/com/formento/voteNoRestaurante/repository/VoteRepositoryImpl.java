package br.com.formento.voteNoRestaurante.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.Vote;

@Transactional
@Repository
public class VoteRepositoryImpl extends AbstractRepository<Vote> implements VoteRepository {

	@Autowired
	public VoteRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

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
		sql.append("   and r.id = ? ");

		List<?> find = getHibernateTemplate().find(sql.toString(), restaurant.getId());
		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>) find;

		if (find == null || find.isEmpty())
			return 0l;
		else {
			Long amount = list.get(0);
			return amount;
		}
	}

}