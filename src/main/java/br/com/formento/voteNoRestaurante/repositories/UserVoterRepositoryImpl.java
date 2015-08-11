package br.com.formento.voteNoRestaurante.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.UserVoter;

@Transactional
@Repository
public class UserVoterRepositoryImpl extends AbstractRepository<UserVoter> implements UserVoterRepository {
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