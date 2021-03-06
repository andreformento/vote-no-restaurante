package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_restaurant")
public class CategoryRestaurant implements Serializable, ModelEntity, Comparable<CategoryRestaurant> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(name = "exhibition_order", nullable = false, unique = true)
	private int exhibitionOrder;

	public CategoryRestaurant() {
	}

	public CategoryRestaurant(String description, int exhibitionOrder) {
		this.description = description;
		this.exhibitionOrder = exhibitionOrder;
	}

	public CategoryRestaurant(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public int getExhibitionOrder() {
		return exhibitionOrder;
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
		CategoryRestaurant other = (CategoryRestaurant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryRestaurant [id=" + id + ", description=" + description + ", exhibitionOrder=" + exhibitionOrder + "]";
	}

	@Override
	public int compareTo(CategoryRestaurant o) {
		return description.compareTo(o.description);
	}

}
