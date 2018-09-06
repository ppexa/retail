package com.demo.myretail.service;

import com.demo.myretail.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	List<Product> getAllProducts();

	Optional<Product> getProductById(String id);

	void deleteProductById(String id);

	void modifyProductById(String id, String name, String price, String currency, String department);

	void createProduct(String name, String price, String currency, String department);

}
