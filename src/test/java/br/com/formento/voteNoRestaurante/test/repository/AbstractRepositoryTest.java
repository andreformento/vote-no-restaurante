package br.com.formento.voteNoRestaurante.test.repository;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public abstract class AbstractRepositoryTest {

	@Mock
	private EntityManager entityManager;

	@Before
	public final void init() {
		MockitoAnnotations.initMocks(this);
		initializeRepository();
	}

	protected abstract void initializeRepository();

	@Test
	public void testHibernateTemplateIsNotNull() {
		assertNotNull(entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
