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
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public @ResponseBody
	List<Product> products() {
		return productService.getAllProducts();

	}

	@RequestMapping("/{productId}")
	public @ResponseBody
	Product product(@PathVariable("productId") String id) {
		Optional<Product> optionalProduct = productService.getProductById(id);
		return optionalProduct.isPresent() ? optionalProduct.get() : new Product();
	}

	@RequestMapping("/delete/{productId}")
	public @ResponseBody
	void delete(@PathVariable("productId") String id) {
		productService.deleteProductById(id);
	}

	@RequestMapping("/update")
	public @ResponseBody
	void update(@RequestParam(value = "productId") String id,
				@RequestParam(value = "name") String name,
				@RequestParam(value = "price") String price,
				@RequestParam(value = "currency") String currency,
				@RequestParam(value = "department", required = false, defaultValue = "misc") String department) {
		productService.modifyProductById(id, name, price, currency, department);
	}

	@RequestMapping("/create")
	public @ResponseBody
	void create(@RequestParam(value = "name") String name,
				@RequestParam(value = "price") String price,
				@RequestParam(value = "currency") String currency,
				@RequestParam(value = "department", required = false, defaultValue = "misc") String department) {
		productService.createProduct(name, price, currency, department);
	}

	@RequestMapping("/create/form")
	public String createForm() {
		return "index";
	}

	@RequestMapping(value = "/create/createFromForm", method = RequestMethod.POST)
	public String createFromForm(String name, String price, String currency, String department) {
		productService.createProduct(name, price, currency, department);
		return "redirect:/products/create/form";
	}

}
