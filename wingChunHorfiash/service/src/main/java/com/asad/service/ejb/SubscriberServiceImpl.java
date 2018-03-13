package com.asad.service.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.asad.service.SubscriberEntity;

@Stateless(name = "subscriber1")
public class SubscriberServiceImpl implements SubscriberService {

	@PersistenceContext(unitName = "wingChun")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SubscriberEntity addSubsecriber(String email) {
		SubscriberEntity subscriber = new SubscriberEntity(email);
		entityManager.persist(subscriber);
		return subscriber;
	}
	
	public boolean findSubscriberByEmail(String email) {
//		try {
		TypedQuery<SubscriberEntity> query = entityManager.createQuery("select s from SubscriberEntity s "
				+ "where s.email = :email",SubscriberEntity.class);
		query.setParameter("email", email);
		if(query.getSingleResult() != null) {
			return true;	
		}
		
//		}catch(Exception e) {		
			return false;
//		}
	}
	
	@Override
	public SubscriberEntity removeSubscriberByEmail(String email) {
		TypedQuery<SubscriberEntity> query = entityManager.createQuery("select s from Subscriber s where s.email = :email",
				SubscriberEntity.class);
		query.setParameter("email", email);
		return query.getSingleResult();

	}
}
