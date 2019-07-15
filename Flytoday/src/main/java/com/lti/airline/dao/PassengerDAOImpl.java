package com.lti.airline.dao;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.airline.model.Passenger;


@Repository
public interface PassengerDAOImpl implements PassengerDAO{

	@Autowired
	SessionFactory sessionFactory;

	public Passenger checkPassenger(Passenger thepassenger) {
		Passenger pass=null;
		Session session=null;
		try {
		 session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Passenger> cq = cb.createQuery(Passenger.class);
		Root<Passenger> root = cq.from(Passenger.class);
		
		//cq.select(root.get("id"));
		cq.select(root).where(cb.and(
				cb.equal(root.get("email"), thepassenger.getEmail()),
				cb.equal(root.get("password"),thepassenger.getPassword())
			));
		
		Query query = session.createQuery(cq);
		query.setMaxResults(1);
		usr=(User) query.getSingleResult();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return pass;
	}

}


