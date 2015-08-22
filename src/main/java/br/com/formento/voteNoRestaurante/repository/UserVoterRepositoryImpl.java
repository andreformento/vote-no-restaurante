package br.com.formento.voteNoRestaurante.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.UserVoter;

@Transactional
@Repository
public class UserVoterRepositoryImpl extends AbstractRepository<UserVoter> implements UserVoterRepository {

	@Autowired
	public UserVoterRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	@Override
	public UserVoter getByEmail(String email) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select uv");
		sql.append(" from UserVoter uv");
		sql.append(" where upper(uv.email) = upper(?) ");

		List<?> find = getHibernateTemplate().find(sql.toString(), email);

		if (find == null || find.isEmpty())
			return null;
		else {
			@SuppressWarnings("unchecked")
			List<UserVoter> list = (List<UserVoter>) find;
			return list.get(0);
		}
	}

}