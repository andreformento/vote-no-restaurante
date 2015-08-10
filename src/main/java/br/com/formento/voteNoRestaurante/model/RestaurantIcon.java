package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_icon")
public class RestaurantIcon implements Serializable, ModelEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(referencedColumnName = "id", name = "id_restaurant_icon", nullable = false)
	private Restaurant restaurant;

	@Column(name = "image_name", unique = true, nullable = false)
	private String imageName;

	@Lob
	@Column(unique = false, nullable = false)
	private byte[] icon;

	public RestaurantIcon() {
	}

	public Long getId() {
		return restaurant.getId();
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public String getImageName() {
		return imageName;
	}

	public byte[] getIcon() {
		return icon;
	}

	@Override
	public int hashCode() {
		return restaurant.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return restaurant.equals(obj);
	}

}
