package br.com.formento.voteNoRestaurante.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;

@Transactional
@Repository
public class CategoryRestaurantRepositoryImpl extends AbstractRepository<CategoryRestaurant> implements CategoryRestaurantRepository {

	@Autowired
	public CategoryRestaurantRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	@Override
	public List<CategoryRestaurant> getEntities() {
		List<?> find = getHibernateTemplate().find("from CategoryRestaurant cr order by cr.exhibitionOrder");
		@SuppressWarnings("unchecked")
		List<CategoryRestaurant> list = (List<CategoryRestaurant>) find;
		return list;
	}

	@Override
	public CategoryRestaurant getNextByOrder(int order) {
		DetachedCriteria detachedCriteria = generateDetachedCriteria();
		detachedCriteria.add(Property.forName("exhibitionOrder").gt(order));

		detachedCriteria.addOrder(Order.asc("exhibitionOrder"));

		List<?> find = getHibernateTemplate().findByCriteria(detachedCriteria, 0, 1);

		@SuppressWarnings("unchecked")
		List<CategoryRestaurant> list = (List<CategoryRestaurant>) find;
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

}