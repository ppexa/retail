package com.demo.myretail;

import com.demo.myretail.controller.dao.ProductRepository;
import com.demo.myretail.domain.CurrentPrice;
import com.demo.myretail.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyRetailApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.deleteAll();
		productRepository.save(new Product("title", new CurrentPrice(12.90, "USD")));

		System.out.println(productRepository.findAll());
	}
}
