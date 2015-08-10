package br.com.formento.voteNoRestaurante.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComputationVote implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Vote> voteList;
	private UserVoter userVoter;

	public ComputationVote() {
		voteList = new ArrayList<Vote>();
		userVoter = new UserVoter();
	}

	public List<Vote> getVoteList() {
		return voteList;
	}

	public UserVoter getUserVoter() {
		return userVoter;
	}

	@Override
	public String toString() {
		return "ComputationVote [voteList=" + voteList + ", userVoter=" + userVoter + "]";
	}

}
