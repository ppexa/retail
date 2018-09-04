package com.demo.myretail.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class Product {

	@Id
	private String id;
	private String name;
	private CurrentPrice currentPrice;

	public Product(String name, CurrentPrice currentPrice) {
		this.name = name;
		this.currentPrice = currentPrice;
	}

}
