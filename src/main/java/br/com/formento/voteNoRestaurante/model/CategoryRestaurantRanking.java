package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.TreeMap;

public class CategoryRestaurantRanking implements Serializable, Comparable<CategoryRestaurantRanking> {

	private static final long serialVersionUID = 1L;

	private CategoryRestaurant categoryRestaurant;
	private TreeMap<Long, Restaurant> list;
	private Restaurant restaurantChoice;

	public CategoryRestaurantRanking(CategoryRestaurant categoryRestaurant) {
		this.categoryRestaurant = categoryRestaurant;
		this.list = new TreeMap<>(Collections.reverseOrder());
	}

	@Override
	public int compareTo(CategoryRestaurantRanking o) {
		return categoryRestaurant.compareTo(o.categoryRestaurant);
	}

	public CategoryRestaurant getCategoryRestaurant() {
		return categoryRestaurant;
	}

	public TreeMap<Long, Restaurant> getList() {
		return list;
	}

	public void addRestaurant(Restaurant restaurant, Long amountVotes) {
		list.put(amountVotes, restaurant);
	}

	public Restaurant getRestaurantChoice() {
		return restaurantChoice;
	}

	public void setRestaurantChoice(Restaurant restaurantChoice) {
		this.restaurantChoice = restaurantChoice;
	}

}
