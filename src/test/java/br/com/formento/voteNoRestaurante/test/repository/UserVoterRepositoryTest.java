package br.com.formento.voteNoRestaurante.test.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.formento.voteNoRestaurante.repository.UserVoterRepository;
import br.com.formento.voteNoRestaurante.repository.UserVoterRepositoryImpl;

public class UserVoterRepositoryTest extends AbstractRepositoryTest {

	private UserVoterRepository repository;

	@Override
	public void initializeRepository() {
		repository = new UserVoterRepositoryImpl(getHibernateTemplate());
	}

	@Test
	public void testRepositoryIsNotNull() {
		assertNotNull(repository);
	}
	
	@Test
	public void testGetByEmail(){
		// TODO continuar mock
		// http://blog.caelum.com.br/facilitando-seus-testes-de-unidade-no-java-um-pouco-de-mockito/
//		repository.getByEmail()
	}

}
