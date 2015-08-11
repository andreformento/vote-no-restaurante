package br.com.formento.voteNoRestaurante.controller.form;

import java.io.Serializable;
import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;

public class FormChoiceRestaurant implements Serializable, FormView {

	private static final long serialVersionUID = 1L;

	private CategoryRestaurant categoryRestaurant;
	private List<Restaurant> restaurantList;

	public FormChoiceRestaurant() {
	}

	public FormChoiceRestaurant(CategoryRestaurant categoryRestaurant) {
		this.categoryRestaurant = categoryRestaurant;
	}

	public CategoryRestaurant getCategoryRestaurant() {
		return categoryRestaurant;
	}

	public void setCategoryRestaurant(CategoryRestaurant categoryRestaurant) {
		this.categoryRestaurant = categoryRestaurant;
	}

	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

}
