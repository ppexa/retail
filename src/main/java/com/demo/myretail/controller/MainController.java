package com.demo.myretail.controller;

import com.demo.myretail.controller.service.ProductService;
import com.demo.myretail.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public @ResponseBody
	List<Product> products() {
		return productService.getAllProducts();
	}

	@RequestMapping("/products/{prodId}")
	public @ResponseBody
	Product product(@PathVariable("prodId") String id) {
		Optional<Product> optionalProduct = productService.getProductById(id);
		return optionalProduct.isPresent() ? optionalProduct.get(): new Product();
	}

}
