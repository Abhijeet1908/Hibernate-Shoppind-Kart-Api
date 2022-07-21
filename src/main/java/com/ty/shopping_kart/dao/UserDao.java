package com.ty.shopping_kart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.shopping_kart.dto.Product;
import com.ty.shopping_kart.dto.User;

public class UserDao {

	public User saveUser(User user) {
		//This method saves the details of the user in the database and it will return the details of the User from the database
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		User users = entityManager.find(User.class, user.getId());
		return users;
	}

	public User getUserById(int id) {
		//THis method will give the details of the user from the database whose id matches with the passed id value
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		User user = entityManager.find(User.class, id);
		if (user != null) {
			return user;
		}
		return null;

	}

	public List<User> getAllUser() {
		//This method will return details of a all the users from the database
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT u FROM User u";

		Query query = entityManager.createQuery(sql);

		List<User> users = query.getResultList();

		return users;
	}

	public User validateUser(String email, String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2";

		Query query = entityManager.createQuery(sql);

		query.setParameter(1, email);

		query.setParameter(2, password);

		List<User> users = query.getResultList();
		return users.get(0);

	}

	public boolean deleteUserById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, id);

		if (user != null) {
			entityTransaction.begin();

			entityManager.remove(user);

			entityTransaction.commit();

			return true;
		}
		return false;
	}
	public User updateUserById(User user, int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User ut = getUserById(id);

		entityTransaction.begin();

		entityManager.merge(user);

		entityTransaction.commit();

		if (ut != null) {

			System.out.println("Modification Sucessful");

		} else {
			System.out.println("No exixting product found so new entry added");
		}
		return user;

	}

}
