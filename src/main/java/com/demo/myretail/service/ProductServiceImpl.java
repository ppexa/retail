package com.demo.myretail.service;

import com.demo.myretail.dao.ProductRepository;
import com.demo.myretail.domain.CurrentPrice;
import com.demo.myretail.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Value("${starting.id}")
	private String startingId;

	@Value("${entertainment.prefix}")
	private String entertainmentPrefix;

	@Value("${outdoor.prefix}")
	private String outdoorPrefix;

	@Value("${apparel.prefix}")
	private String apparelPrefix;

	@Value("${home.prefix}")
	private String homePrefix;

	@Value("${misc.prefix}")
	private String miscPrefix;

	private final String ENTERTAINMENT = "ENTERTAINMENT";
	private final String OUTDOOR = "OUTDOOR";
	private final String APPAREL = "APPAREL";
	private final String HOME = "HOME";
	private final String MISC = "MISC";

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
	public void modifyProductById(String id, String name, String price, String currency, String department) {
		deleteProductById(id);
		productRepository.save(new Product(id, name, new CurrentPrice(price, currency), department));
	}

	@Override
	public void createProduct(String name, String price, String currency, String department) {
		productRepository.save(new Product(createNewId(department), name, new CurrentPrice(price, currency), department));
	}

	private String createNewId(String department) {
		String id;
		String idPrefix = "";
		List<Product> productList = getAllProducts();

//		Logic for getting products with certain department
		List<Product> sortedProducts = productList.stream()
				.filter(product -> product.getDepartment().equals(department))
				.sorted(Comparator.comparing(Product::getId))
				.collect(Collectors.toList());

		if (sortedProducts.size() > 0) {
			Product product1 = sortedProducts.get(sortedProducts.size() - 1);
			int id1 = Integer.parseInt(product1.getId()) + 1;
			id = String.valueOf(id1);
		} else {
			id = getProductIdPrefix(department) + startingId;
		}

		return idPrefix + id;
	}

	private String getProductIdPrefix(String department) {
		String idPrefix = "";
		switch (department.toUpperCase()) {
			case ENTERTAINMENT:
				idPrefix = entertainmentPrefix;
				break;
			case OUTDOOR:
				idPrefix = outdoorPrefix;
				break;
			case APPAREL:
				idPrefix = apparelPrefix;
				break;
			case HOME:
				idPrefix = homePrefix;
				break;
			case MISC:
				idPrefix = miscPrefix;
		}
		return idPrefix;
	}
}
