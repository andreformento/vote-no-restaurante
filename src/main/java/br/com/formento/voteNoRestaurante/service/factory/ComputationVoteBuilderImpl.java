package br.com.formento.voteNoRestaurante.service.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.UserVoter;
import br.com.formento.voteNoRestaurante.model.Vote;

public class ComputationVoteBuilderImpl extends ComputationVoteBuilder {

	private List<Restaurant> restaurantList;

	public ComputationVoteBuilderImpl(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

	@Override
	protected void buildUserVoter() {
		getInstance().setUserVoter(new UserVoter());
	}

	/**
	 * transforma os restaurantes escolhidos em votos
	 */
	@Override
	protected void buildVoteList() {
		List<Vote> voteList = new ArrayList<Vote>();
		for (Restaurant restaurant : restaurantList)
			voteList.add(new Vote(restaurant, getInstance()));

		getInstance().setVoteList(voteList);
	}

	@Override
	protected void buildDateCreate() {
		Date dateCreate = new Date();
		getInstance().setDateCreate(dateCreate);
	}

}
