package br.com.formento.voteNoRestaurante.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.CategoryRestaurantRanking;
import br.com.formento.voteNoRestaurante.model.Ranking;
import br.com.formento.voteNoRestaurante.model.Restaurant;

public class RankingTest {
	private Ranking ranking;
	private CategoryRestaurant crA;
	private CategoryRestaurant crB;
	private Restaurant rA;
	private Restaurant rB;

	@Before
	public void instanciar() {
		crA = new CategoryRestaurant(1l, "A");
		rA = new Restaurant(1l, crA);

		crB = new CategoryRestaurant(2l, "B");
		rB = new Restaurant(2l, crB);

		ranking = new Ranking();
		ranking.addRestaurant(rA, 0l);
		ranking.addRestaurant(rB, 0l);
	}

	@Test
	public void testSetRestaurantChoice() {
		assertNull(ranking.getCategoryRestaurantRankingByRestaurant(rA).getRestaurantChoice());
		ranking.setRestaurantChoice(rA);
		assertNotNull(ranking.getCategoryRestaurantRankingByRestaurant(rA).getRestaurantChoice());
	}

	@Test
	public void test2Categorias() {
		TreeMap<CategoryRestaurant, CategoryRestaurantRanking> list = ranking.getList();

		assertEquals(crA, list.firstEntry().getKey());
		list.remove(crA);

		assertEquals(crB, list.firstEntry().getKey());
		list.remove(crB);

		assertTrue(list.isEmpty());
	}

}
