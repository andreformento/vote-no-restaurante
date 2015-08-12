package br.com.formento.voteNoRestaurante.service.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.RestaurantIcon;
import br.com.formento.voteNoRestaurante.util.FileToArrayOfBytes;

public class InitializationCacheBuilderImpl extends InitializationCacheBuilder {

	private CategoryRestaurant pizzaria;
	private CategoryRestaurant hamburgueria;

	private Restaurant pizzaHut;
	private Restaurant dominos;

	private Restaurant hamburgueriaDoSujinho;
	private Restaurant hamburgueriaNacional;
	private Restaurant theFifties;

	private RestaurantIcon pizzaHutIcon;
	private RestaurantIcon dominosIcon;

	private RestaurantIcon hamburgueriaDoSujinhoIcon;
	private RestaurantIcon hamburgueriaNacionalIcon;
	private RestaurantIcon theFiftiesIcon;

	public InitializationCacheBuilderImpl() {
	}

	@Override
	protected void buildListCategoryRestaurant() {
		pizzaria = new CategoryRestaurant("Pizzaria", 1);
		hamburgueria = new CategoryRestaurant("Hamburgueria", 2);

		List<CategoryRestaurant> list = new ArrayList<>();
		list.add(pizzaria);
		list.add(hamburgueria);

		getInstance().setListCategoryRestaurant(list);
	}

	@Override
	protected void buildListRestaurant() {
		pizzaHut = new Restaurant("Pizza Hut", pizzaria);
		dominos = new Restaurant("Dominos", pizzaria);

		hamburgueriaDoSujinho = new Restaurant("Hamburgueria do Sujinho", hamburgueria);
		hamburgueriaNacional = new Restaurant("Hamburgueria Nacional", hamburgueria);
		theFifties = new Restaurant("The Fifties", hamburgueria);

		List<Restaurant> list = new ArrayList<>();
		list.add(pizzaHut);
		list.add(dominos);

		list.add(hamburgueriaDoSujinho);
		list.add(hamburgueriaNacional);
		list.add(theFifties);

		getInstance().setListRestaurant(list);
	}

	@Override
	protected void buildListRestaurantIcon() {
		pizzaHutIcon = new RestaurantIcon(pizzaHut, "1pizzaria_pizza_hut.png", readImage("1pizzaria_pizza_hut.png"));
		dominosIcon = new RestaurantIcon(dominos, "2pizzaria_dominos.png", readImage("2pizzaria_dominos.png"));

		hamburgueriaDoSujinhoIcon = new RestaurantIcon(hamburgueriaDoSujinho, "3hambuergueria_sujinho.jpg", readImage("3hambuergueria_sujinho.jpg"));
		hamburgueriaNacionalIcon = new RestaurantIcon(hamburgueriaNacional, "4hambuergueria_nacional.jpg", readImage("4hambuergueria_nacional.jpg"));
		theFiftiesIcon = new RestaurantIcon(theFifties, "5thefifties.png", readImage("5thefifties.png"));

		List<RestaurantIcon> list = new ArrayList<>();
		list.add(pizzaHutIcon);
		list.add(dominosIcon);
		list.add(hamburgueriaDoSujinhoIcon);
		list.add(hamburgueriaNacionalIcon);
		list.add(theFiftiesIcon);

		getInstance().setListRestaurantIcon(list);
	}

	private byte[] readImage(String fileName) {
		FileToArrayOfBytes fileToArrayOfBytes = new FileToArrayOfBytes();
		String pathDir = fileToArrayOfBytes.getPathDir("initApp/" + fileName);

		byte[] fileRead = fileToArrayOfBytes.fileRead(pathDir);

		return fileRead;
	}

}
