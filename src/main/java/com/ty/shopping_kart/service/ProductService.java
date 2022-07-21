package com.ty.shopping_kart.service;

import java.util.List;

import com.ty.shopping_kart.dao.ProductDao;
import com.ty.shopping_kart.dto.Product;

public class ProductService {
	ProductDao dao = new ProductDao();

	public Product saveProduct(Product product) {

		return dao.saveProduct(product);

	}

	public Product getProductById(int Id) {

		return dao.getProductById(Id);
	}

	public Product getProductByBrand(String brand) {

		return dao.getProductByBrand(brand);
	}

	public Product getProductByName(String name) {

		return dao.getProductByName(name);
	}

	public Product getProductByPrice(Double price) {

		return dao.getProductByPrice(price);
	}

	public Product getProductByRating(Double rating) {

		return dao.getProductByRating(rating);
	}

	public List<Product> getAllProducts() {

		return dao.getAllProducts();

	}

	public Product updateProductById(Product product, int id) {

		return dao.updateProductById(product, id);

	}

	public boolean deleteProductById(int id) {

		return dao.deleteProductById(id);
	}

	public Product getProductByNameAndBrand(String name, String brand) {

		return dao.getProductByNameAndBrand(name, brand);
	}

}
