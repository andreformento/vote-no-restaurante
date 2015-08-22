package br.com.formento.voteNoRestaurante.test.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class AbstractRepositoryTest {

	@Mock
	private HibernateTemplate hibernateTemplate;

	@Before
	public final void init() {
		MockitoAnnotations.initMocks(this);
		initializeRepository();
	}

	protected abstract void initializeRepository();

	@Test
	public void testHibernateTemplateIsNotNull() {
		assertNotNull(hibernateTemplate);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}
