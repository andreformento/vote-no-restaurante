package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;
import java.util.List;

public class FormChoiceRestaurant implements Serializable {

	private static final long serialVersionUID = 1L;

	private CategoryRestaurant categoryRestaurant;
	private List<Restaurant> restaurantList;

	private Restaurant restaurantVote;
	
	// TODO list de restaurantes já votados

	public FormChoiceRestaurant() {
	}

	public FormChoiceRestaurant(CategoryRestaurant categoryRestaurant) {
		this.categoryRestaurant = categoryRestaurant;
	}

	public CategoryRestaurant getCategoryRestaurant() {
		return categoryRestaurant;
	}

	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public Restaurant getRestaurantVote() {
		return restaurantVote;
	}

	public void setRestaurantVote(Restaurant restaurantVote) {
		this.restaurantVote = restaurantVote;
	}

}
