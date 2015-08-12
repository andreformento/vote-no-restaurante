package br.com.formento.voteNoRestaurante.model;

import java.util.List;

public class InitializationCache {

	private List<CategoryRestaurant> listCategoryRestaurant;
	private List<Restaurant> listRestaurant;
	private List<RestaurantIcon> listRestaurantIcon;

	public InitializationCache() {
	}

	public List<CategoryRestaurant> getListCategoryRestaurant() {
		return listCategoryRestaurant;
	}

	public void setListCategoryRestaurant(List<CategoryRestaurant> listCategoryRestaurant) {
		this.listCategoryRestaurant = listCategoryRestaurant;
	}

	public List<Restaurant> getListRestaurant() {
		return listRestaurant;
	}

	public void setListRestaurant(List<Restaurant> listRestaurant) {
		this.listRestaurant = listRestaurant;
	}

	public List<RestaurantIcon> getListRestaurantIcon() {
		return listRestaurantIcon;
	}

	public void setListRestaurantIcon(List<RestaurantIcon> listRestaurantIcon) {
		this.listRestaurantIcon = listRestaurantIcon;
	}

}
