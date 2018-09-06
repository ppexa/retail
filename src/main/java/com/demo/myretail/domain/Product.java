package com.demo.myretail.domain;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product {

	private String id;
	private String name;
	private CurrentPrice currentPrice;
	private String department;

}
