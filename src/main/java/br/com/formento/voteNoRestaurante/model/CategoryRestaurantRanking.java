package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;
import java.util.TreeSet;

public class CategoryRestaurantRanking implements Serializable, Comparable<CategoryRestaurantRanking> {

	private static final long serialVersionUID = 1L;

	private CategoryRestaurant categoryRestaurant;
	private TreeSet<RestaurantCount> list;
	private Restaurant restaurantChoice;

	public CategoryRestaurantRanking(CategoryRestaurant categoryRestaurant) {
		this.categoryRestaurant = categoryRestaurant;
		this.list = new TreeSet<>();
	}

	@Override
	public int compareTo(CategoryRestaurantRanking o) {
		int compareTo = categoryRestaurant.compareTo(o.categoryRestaurant);
		if (compareTo == 0)
			return categoryRestaurant.getId().compareTo(o.categoryRestaurant.getId());
		else
			return compareTo;
	}

	public CategoryRestaurant getCategoryRestaurant() {
		return categoryRestaurant;
	}

	public TreeSet<RestaurantCount> getList() {
		return list;
	}

	public void addRestaurant(Restaurant restaurant, Long amountVotes) {
		list.add(new RestaurantCount(restaurant, amountVotes));
	}

	public Restaurant getRestaurantChoice() {
		return restaurantChoice;
	}

	public void setRestaurantChoice(Restaurant restaurantChoice) {
		this.restaurantChoice = restaurantChoice;
	}

}
