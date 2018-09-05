package com.demo.myretail.service;

import com.demo.myretail.dao.ProductRepository;
import com.demo.myretail.domain.CurrentPrice;
import com.demo.myretail.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(String id) {
		return productRepository.findById(id);
	}

	@Override
	public void deleteProductById(String id) {
		productRepository.deleteById(id);
	}

	@Override
	public void modifyProductById(Product product) {
		productRepository.save(product);
	}

	@Override
	public void createProduct(String name, String price, String currency) {
//		Product product = new Product(name, new CurrentPrice(price, currency));

		productRepository.save(new Product(name, new CurrentPrice(price, currency)));
	}
}
