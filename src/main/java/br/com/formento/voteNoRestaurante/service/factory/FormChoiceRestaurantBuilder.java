package br.com.formento.voteNoRestaurante.service.factory;

import br.com.formento.voteNoRestaurante.controller.form.FormChoiceRestaurant;

public abstract class FormChoiceRestaurantBuilder implements Builder<FormChoiceRestaurant> {

	private FormChoiceRestaurant instance;

	public FormChoiceRestaurantBuilder() {
		this.instance = new FormChoiceRestaurant();
	}

	protected abstract void buildCategoryRestaurant();

	protected abstract void buildRestaurantList();

	@Override
	public FormChoiceRestaurant getInstance() {
		return instance;
	}

}
