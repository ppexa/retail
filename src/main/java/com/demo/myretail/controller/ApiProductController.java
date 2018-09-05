package com.demo.myretail.controller;

import com.demo.myretail.service.ProductService;
import com.demo.myretail.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ApiProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping()
	public @ResponseBody
	List<Product> products() {
		return productService.getAllProducts();
	}

	@RequestMapping("/{prodId}")
	public @ResponseBody
	Product product(@PathVariable("prodId") String id) {
		Optional<Product> optionalProduct = productService.getProductById(id);
		return optionalProduct.isPresent() ? optionalProduct.get(): new Product();
	}

	@RequestMapping("/delete/{prodId}")
	public @ResponseBody
	void delete(@PathVariable("prodId") String id) {
		productService.deleteProductById(id);
	}

//	@RequestMapping("/update/{prodId}")
//	public @ResponseBody
//	void update(@PathVariable("prodId") String id) {
//
//		productService.modifyProductById(id);
//	}

	@RequestMapping("/create")
	public @ResponseBody
	List<Product> create(@RequestParam(value="name") String name, @RequestParam(value="price") String price,
				@RequestParam(value="currency") String currencyCode) {
		productService.createProduct(name, price, currencyCode);
		return products();
	}

}
