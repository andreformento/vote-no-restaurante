package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "date_create", nullable = false)
	private Date dateCreate;

	@Column(nullable = false)
	private String email;

	@Column(name = "confirmation_date")
	private Date confirmationDate;

	public Vote(Long id, Date dateCreate, String email) {
		this.id = id;
		this.dateCreate = dateCreate;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public String getEmail() {
		return email;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public boolean isConfirmed() {
		return confirmationDate != null;
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

}
