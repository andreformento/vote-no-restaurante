package br.com.formento.voteNoRestaurante.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.voteNoRestaurante.model.LinkMail;
import br.com.formento.voteNoRestaurante.model.LinkMailImpl;

public class LinkMailImplTest {

	private String baseUrl;
	private String link;
	private LinkMail linkMail;

	@Before
	public void instanciar() {
		baseUrl = "localhost:8080/";
		link = "vote/confirm";

		linkMail = new LinkMailImpl(baseUrl, link);
	}

	@Test
	public void testSemParametros() {
		String full = baseUrl + link;
		assertEquals(full, linkMail.generateFullLink());
	}

	@Test
	public void test1Parametro() {
		linkMail.addParameter("param1", 7);

		String full = baseUrl + link + "?param1=7";
		assertEquals(full, linkMail.generateFullLink());
	}

	@Test
	public void test2Parametros() {
		linkMail.addParameter("paramStr", 9);
		linkMail.addParameter("paramNum", "pedro");

		String full = baseUrl + link + "?paramStr=9&paramNum=pedro";
		assertEquals(full, linkMail.generateFullLink());
	}

	@Test
	public void testParametroNull() {
		linkMail.addParameter("paramNull", null);

		String full = baseUrl + link;
		assertEquals(full, linkMail.generateFullLink());
	}

}
