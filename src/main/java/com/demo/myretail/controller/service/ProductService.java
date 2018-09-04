package com.demo.myretail.controller.service;

import com.demo.myretail.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	List<Product> getAllProducts();

	Optional<Product> getProductById(String id);

	void deleteProductById(String id);

	void modifyProductById(Product product);

	void createProduct(Product product);

}
