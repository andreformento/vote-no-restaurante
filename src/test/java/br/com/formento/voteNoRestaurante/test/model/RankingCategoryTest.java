package br.com.formento.voteNoRestaurante.test.model;

import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.CategoryRestaurantRanking;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.RestaurantCount;

public class RankingCategoryTest {
	private Restaurant r1;
	private Restaurant r2;
	private Restaurant r3;
	private Restaurant r4;
	private Restaurant r5;

	private CategoryRestaurant categoryRestaurant;
	private CategoryRestaurantRanking categoryRestaurantRanking;

	@Before
	public void instanciar() {
		categoryRestaurant = new CategoryRestaurant("A", 0);
		categoryRestaurantRanking = new CategoryRestaurantRanking(categoryRestaurant);

		r1 = new Restaurant(1l, "A", categoryRestaurant);
		r2 = new Restaurant(2l, "B", categoryRestaurant);
		r3 = new Restaurant(3l, "C", categoryRestaurant);
		r4 = new Restaurant(4l, "D", categoryRestaurant);
		r5 = new Restaurant(5l, "E", categoryRestaurant);
	}

	@Test
	public void test1Categoria4Restaurantes() {
		categoryRestaurantRanking.addRestaurant(r1, 15l);
		categoryRestaurantRanking.addRestaurant(r2, 10l);
		categoryRestaurantRanking.addRestaurant(r3, 20l);
		categoryRestaurantRanking.addRestaurant(r4, 5l);

		TreeSet<RestaurantCount> listRestaurantCount = categoryRestaurantRanking.getList();
		RestaurantCount entry;

		entry = listRestaurantCount.first();
		Assert.assertEquals(new RestaurantCount(r3, Long.valueOf(20)), entry);
		listRestaurantCount.remove(entry);

		entry = listRestaurantCount.first();
		Assert.assertEquals(new RestaurantCount(r1, Long.valueOf(15)), entry);
		listRestaurantCount.remove(entry);

		entry = listRestaurantCount.first();
		Assert.assertEquals(new RestaurantCount(r2, Long.valueOf(10)), entry);
		listRestaurantCount.remove(entry);

		entry = listRestaurantCount.first();
		Assert.assertEquals(new RestaurantCount(r4, Long.valueOf(5)), entry);
		listRestaurantCount.remove(entry);

		Assert.assertTrue(listRestaurantCount.isEmpty());
	}

	@Test
	public void testRestaurantesMesmaQuantidadeVotos() {
		categoryRestaurantRanking.addRestaurant(r4, 5l);
		categoryRestaurantRanking.addRestaurant(r5, 5l);

		TreeSet<RestaurantCount> listRestaurantCount = categoryRestaurantRanking.getList();
		RestaurantCount entry;

		entry = listRestaurantCount.first();
		Assert.assertEquals(new RestaurantCount(r4, Long.valueOf(5)), entry);
		listRestaurantCount.remove(entry);

		entry = listRestaurantCount.first();
		Assert.assertEquals(new RestaurantCount(r5, Long.valueOf(5)), entry);
		listRestaurantCount.remove(entry);

		Assert.assertTrue(listRestaurantCount.isEmpty());
	}

}
