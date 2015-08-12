package br.com.formento.voteNoRestaurante.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.CategoryRestaurantRanking;
import br.com.formento.voteNoRestaurante.model.Restaurant;

public class RankingCategoryTest {
	private Restaurant r1;
	private Restaurant r2;
	private Restaurant r3;
	private Restaurant r4;

	private CategoryRestaurant categoryRestaurant;
	private CategoryRestaurantRanking categoryRestaurantRanking;

	@Before
	public void instanciar() {
		categoryRestaurant = new CategoryRestaurant("A", 0);
		categoryRestaurantRanking = new CategoryRestaurantRanking(categoryRestaurant);

		r1 = new Restaurant(1l, categoryRestaurant);
		r2 = new Restaurant(2l, categoryRestaurant);
		r3 = new Restaurant(3l, categoryRestaurant);
		r4 = new Restaurant(4l, categoryRestaurant);

		categoryRestaurantRanking.addRestaurant(r1, 15l);
		categoryRestaurantRanking.addRestaurant(r2, 10l);
		categoryRestaurantRanking.addRestaurant(r3, 20l);
		categoryRestaurantRanking.addRestaurant(r4, 5l);
	}

	@Test
	public void test1Categoria4Restaurantes() {

		TreeMap<Long, Restaurant> treeMap = categoryRestaurantRanking.getList();
		Entry<Long, Restaurant> entry;

		entry = treeMap.firstEntry();
		assertEquals(Long.valueOf(20), entry.getKey());
		assertEquals(r3, entry.getValue());
		treeMap.remove(entry.getKey());

		entry = treeMap.firstEntry();
		assertEquals(Long.valueOf(15), entry.getKey());
		assertEquals(r1, entry.getValue());
		treeMap.remove(entry.getKey());

		entry = treeMap.firstEntry();
		assertEquals(Long.valueOf(10), entry.getKey());
		assertEquals(r2, entry.getValue());
		treeMap.remove(entry.getKey());

		entry = treeMap.firstEntry();
		assertEquals(Long.valueOf(5), entry.getKey());
		assertEquals(r4, entry.getValue());
		treeMap.remove(entry.getKey());

		assertTrue(treeMap.isEmpty());
	}

}
