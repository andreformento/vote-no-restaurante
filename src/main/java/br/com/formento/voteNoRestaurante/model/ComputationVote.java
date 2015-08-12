package br.com.formento.voteNoRestaurante.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "computation_vote")
public class ComputationVote implements ModelEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "computationVote")
	private List<Vote> voteList;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "id_user_voter", nullable = false)
	private UserVoter userVoter;

	@Column(name = "date_create", nullable = false)
	private Date dateCreate;

	@Column(name = "confirmation_date")
	private Date confirmationDate;

	public List<Vote> getVoteList() {
		return voteList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVoteList(List<Vote> voteList) {
		this.voteList = voteList;
	}

	@Override
	public Long getId() {
		return id;
	}

	public UserVoter getUserVoter() {
		return userVoter;
	}

	public void setUserVoter(UserVoter userVoter) {
		this.userVoter = userVoter;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
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
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("ComputationVote [id=");
		message.append(id);
		message.append(", userVoter=");
		message.append(userVoter);
		message.append(", confirmationDate=");
		message.append(confirmationDate);
		message.append(", dateCreate=");
		message.append(dateCreate);
		message.append(", listSize=");

		if (voteList == null)
			message.append("null");
		else
			message.append(voteList.size());

		message.append("]");

		return message.toString();
	}

}
