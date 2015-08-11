package br.com.formento.voteNoRestaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote implements ModelEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "id_restaurant", nullable = false)
	private Restaurant restaurant;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "id_computation_vote", nullable = false)
	private ComputationVote computationVote;

	public Vote() {
	}

	public Vote(Restaurant restaurant, ComputationVote computationVote) {
		this.restaurant = restaurant;
		this.computationVote = computationVote;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setComputationVote(ComputationVote computationVote) {
		this.computationVote = computationVote;
	}

	public Long getId() {
		return id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public ComputationVote getComputationVote() {
		return computationVote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Vote other = (Vote) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", restaurant=" + restaurant + ", computationVote=" + computationVote + "]";
	}

}
