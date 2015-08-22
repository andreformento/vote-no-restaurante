package br.com.formento.voteNoRestaurante.test.repository;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.formento.voteNoRestaurante.model.UserVoter;
import br.com.formento.voteNoRestaurante.repository.UserVoterRepository;
import br.com.formento.voteNoRestaurante.repository.UserVoterRepositoryImpl;
public class UserVoterRepositoryTest extends AbstractRepositoryTest {

	private UserVoterRepository repository;

	@Override
	public void initializeRepository() {
//		repository = new UserVoterRepositoryImpl(getHibernateTemplate());
	}

	@Test
	public void testRepositoryIsNotNull() {
		assertNotNull(repository);
	}
	
	// http://blog.caelum.com.br/facilitando-seus-testes-de-unidade-no-java-um-pouco-de-mockito/
	@Test
	public void testGetByEmail(){
		// TODO continuar mock
//		repository.getByEmail()
		
//		Long id = 7l;
//		String name = "Paul";
//		String email = "paul@gmail.com";
//		UserVoter userVoter = new UserVoter(id,name,email);
//		
//		final List<?> userVoterList = Mockito.mock(ArrayList.class);
//		
//		final List<UserVoter> list = new ArrayList<>();
//		list.add(userVoter);
//        final List<?> spyList = Mockito.spy(list);
//		
//		
//		when(getHibernateTemplate().find("12345", email)).thenReturn(list);
//	    Funcionario funci = funcionarioDAO.buscarFuncionario("12345");
//	    Assert.assertEquals("RAPHAEL", funci.getNome());
//	    Assert.assertEquals(2045, funci.getSetor());
//	    Assert.assertEquals("12345", funci.getMatricula());
//	    verify(transacao, atMostOnce()).executar("12345");
	}
	

}
