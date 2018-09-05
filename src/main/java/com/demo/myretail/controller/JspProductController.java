package com.demo.myretail.controller;

import com.demo.myretail.service.ProductService;
import com.demo.myretail.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("ui/products")
public class JspProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping()
	public String products(Model model) {
		model.addAttribute("allProducts", productService.getAllProducts());
		return "product";
	}

	@RequestMapping("/{prodId}")
	public Product product(@PathVariable("prodId") String id) {
		Optional<Product> optionalProduct = productService.getProductById(id);
		return optionalProduct.isPresent() ? optionalProduct.get(): new Product();
	}

	@RequestMapping("/delete/{prodId}")
	public void delete(@PathVariable("prodId") String id) {
		productService.deleteProductById(id);
	}

//	@RequestMapping("/update/{prodId}")
//	public void update(@PathVariable("prodId") String id) {
//
//		productService.modifyProductById(id);
//	}

	@RequestMapping("/create")
	public void create(@RequestParam(value="name") String name, @RequestParam(value="price") String price,
						 @RequestParam(value="currency") String currencyCode) {
		productService.createProduct(name, price, currencyCode);
//		return products();
	}

}
