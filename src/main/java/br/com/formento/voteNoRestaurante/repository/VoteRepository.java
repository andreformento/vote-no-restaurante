package br.com.formento.voteNoRestaurante.repository;

import java.util.List;

import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.Vote;

public interface VoteRepository extends Repository<Vote> {

	List<Vote> getEntities();

	Long getAmountValidVotesByRestaurant(Restaurant restaurant);

}