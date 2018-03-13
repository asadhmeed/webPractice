package com.asad.service.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.asad.service.UserEntity;

@Stateless(name = "User1")
public class UserServiceImpl implements UserService {

	@PersistenceContext(unitName = "wingChun")
	private EntityManager entityManager;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public UserEntity addUser(String userName, String email, String password, boolean emailIsConfirmed) {
		UserEntity user = new UserEntity(userName, email, password, emailIsConfirmed);
		entityManager.persist(user);
		return user;
	}

	@Override
	public UserEntity findUserByEmail(String email, String password) {
		TypedQuery<UserEntity> query = entityManager
				.createQuery("select u from User u "
						+ "where u.email = :email "
						+ "and u.password = :pass", UserEntity.class);
		query.setParameter("email", email);
		query.setParameter("pass", password);
		return query.getSingleResult();

	}

	@Override
	public UserEntity findUserByUserName(String userName, String password) {
		TypedQuery<UserEntity> query = entityManager
				.createQuery("select u from User u "
						+ "where u.userName = :userName "
						+ "and u.password = :pass", UserEntity.class);
		query.setParameter("userName", userName);
		query.setParameter("pass", password);

		return query.getSingleResult();

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean removeUser(UserEntity user) {
		// TODO:try catch
		entityManager.remove(user);
		return true;

	}

}
