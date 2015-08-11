package br.com.formento.voteNoRestaurante.service.factory;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;

public class FormChoiceRestaurantBuilderImpl extends FormChoiceRestaurantBuilder {

	private List<Restaurant> restaurantList;
	private CategoryRestaurant categoryRestaurant;

	public FormChoiceRestaurantBuilderImpl(CategoryRestaurant categoryRestaurant, List<Restaurant> restaurantList) {
		this.categoryRestaurant = categoryRestaurant;
		this.restaurantList = restaurantList;
	}

	@Override
	protected void buildCategoryRestaurant() {
		getInstance().setCategoryRestaurant(categoryRestaurant);
	}

	@Override
	protected void buildRestaurantList() {
		getInstance().setRestaurantList(restaurantList);
	}

}
