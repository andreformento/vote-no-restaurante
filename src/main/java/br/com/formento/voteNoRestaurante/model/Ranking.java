package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;
import java.util.TreeMap;

public class Ranking implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeMap<CategoryRestaurant, CategoryRestaurantRanking> list;

	public Ranking() {
		list = new TreeMap<>();
	}

	public TreeMap<CategoryRestaurant, CategoryRestaurantRanking> getList() {
		return list;
	}

	public CategoryRestaurantRanking getCategoryRestaurantRankingByRestaurant(Restaurant restaurant) {
		CategoryRestaurantRanking categoryRestaurantRanking;
		CategoryRestaurant categoryRestaurant = restaurant.getCategoryRestaurant();
		if (list.containsKey(categoryRestaurant)) {
			categoryRestaurantRanking = list.get(categoryRestaurant);
		} else {
			categoryRestaurantRanking = new CategoryRestaurantRanking(categoryRestaurant);
			list.put(categoryRestaurant, categoryRestaurantRanking);
		}
		return categoryRestaurantRanking;
	}

	public void addRestaurant(Restaurant restaurant, Long amountVotes) {
		getCategoryRestaurantRankingByRestaurant(restaurant).addRestaurant(restaurant, amountVotes);
	}

	public void setRestaurantChoice(Restaurant restaurantChoice) {
		getCategoryRestaurantRankingByRestaurant(restaurantChoice).setRestaurantChoice(restaurantChoice);
	}

}
