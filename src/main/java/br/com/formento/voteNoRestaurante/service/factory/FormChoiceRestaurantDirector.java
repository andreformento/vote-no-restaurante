package br.com.formento.voteNoRestaurante.service.factory;

import br.com.formento.voteNoRestaurante.controller.form.FormChoiceRestaurant;

public class FormChoiceRestaurantDirector implements Director<FormChoiceRestaurant> {
	private FormChoiceRestaurantBuilder builder;

	public FormChoiceRestaurantDirector(FormChoiceRestaurantBuilder builder) {
		this.builder = builder;
	}

	public void createInstance() {
		builder.buildCategoryRestaurant();
		builder.buildRestaurantList();
	}

	public FormChoiceRestaurant getInstance() {
		return builder.getInstance();
	}
}