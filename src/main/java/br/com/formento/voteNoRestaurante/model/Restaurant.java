package br.com.formento.voteNoRestaurante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Restaurant implements ModelEntity, Comparable<Restaurant> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "id_category_restaurant", nullable = false)
	private CategoryRestaurant categoryRestaurant;

	public Restaurant() {
	}

	public Restaurant(String description, CategoryRestaurant categoryRestaurant) {
		this.description = description;
		this.categoryRestaurant = categoryRestaurant;
	}

	public Restaurant(Long id, String description, CategoryRestaurant categoryRestaurant) {
		this(description, categoryRestaurant);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategoryRestaurant(CategoryRestaurant categoryRestaurant) {
		this.categoryRestaurant = categoryRestaurant;
	}

	public CategoryRestaurant getCategoryRestaurant() {
		return categoryRestaurant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", description=" + description + "]";
	}

	@Override
	public int compareTo(Restaurant o) {
		return description.compareTo(o.description);
	}

}
