package br.com.formento.voteNoRestaurante.repository;

import java.util.HashMap;
import java.util.Map;

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
		sql.append(" where upper(uv.email) = upper(:userVoterMail) ");

		Map<String, Object> params = new HashMap<>();
		params.put("userVoterMail", email);

		UserVoter result = getQueryUtilRepository().simpleQueryUniqueResult(sql.toString(), params);
		return result;
	}

}