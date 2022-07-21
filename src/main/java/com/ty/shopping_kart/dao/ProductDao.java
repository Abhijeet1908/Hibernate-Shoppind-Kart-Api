package com.ty.shopping_kart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.shopping_kart.dto.Product;
import com.ty.shopping_kart.dto.User;

public class ProductDao {
	public Product saveProduct(Product product) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction eTransaction = entityManager.getTransaction();

		eTransaction.begin();
		entityManager.persist(product);
		eTransaction.commit();

		Product products = entityManager.find(Product.class, product.getId());

		return products;

	}

	public Product getProductById(int Id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, Id);

		return product;
	}

	public Product getProductByBrand(String brand) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, brand);

		return product;
	}

	public Product getProductByName(String name) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, name);

		return product;
	}

	public Product getProductByPrice(Double price) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, price);

		return product;
	}

	public Product getProductByRating(Double rating) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, rating);

		return product;
	}

	public List<Product> getAllProducts() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT p FROM Product p";

		Query query = entityManager.createQuery(sql);

		List<Product> list = query.getResultList();
		return list;

	}

	public Product updateProductById(Product product, int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Product pt = getProductById(id);

		entityTransaction.begin();

		entityManager.merge(product);

		entityTransaction.commit();

		if (pt != null) {

			System.out.println("Modification Sucessful");

		} else {
			System.out.println("No exixting product found so new entry added");
		}
		return entityManager.find(Product.class, id);

	}

	public boolean deleteProductById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Product product = entityManager.find(Product.class, id);
		if (product != null) {
			entityTransaction.begin();

			entityManager.refresh(id);

			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Product getProductByNameAndBrand(String name, String brand) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT p FROM Product p WHERE p.name = ?1 AND p.brand = ?2";

		Query query = entityManager.createQuery(sql);

		query.setParameter(1, name);

		query.setParameter(2, brand);

		List<Product> product = query.getResultList();
		return product.get(0);
	}
	
	 

}
