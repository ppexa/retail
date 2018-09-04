package com.demo.myretail.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class CurrentPrice {

	private Double value;
	private String currencyCode;

}
