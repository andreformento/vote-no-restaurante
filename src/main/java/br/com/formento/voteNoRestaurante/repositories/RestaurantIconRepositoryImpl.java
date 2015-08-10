package br.com.formento.voteNoRestaurante.repositories;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.RestaurantIcon;

@Transactional
@Repository
public class RestaurantIconRepositoryImpl extends AbstractRepository<RestaurantIcon> implements RestaurantIconRepository {

}