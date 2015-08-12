package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;

public class RestaurantCount implements Serializable, Comparable<RestaurantCount> {

	private static final long serialVersionUID = 1L;

	private Restaurant restaurant;
	private Long amountVotes;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Long getAmountVotes() {
		return amountVotes;
	}

	public RestaurantCount(Restaurant restaurant, Long amountVotes) {
		this.restaurant = restaurant;
		this.amountVotes = amountVotes;
	}

	@Override
	public int compareTo(RestaurantCount o) {
		int compareTo = o.amountVotes.compareTo(amountVotes);
		if (compareTo == 0)
			return restaurant.compareTo(o.restaurant);
		else
			return compareTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountVotes == null) ? 0 : amountVotes.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
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
		RestaurantCount other = (RestaurantCount) obj;
		if (amountVotes == null) {
			if (other.amountVotes != null)
				return false;
		} else if (!amountVotes.equals(other.amountVotes))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RestaurantCount [restaurant=" + restaurant + ", amountVotes=" + amountVotes + "]";
	}

}
