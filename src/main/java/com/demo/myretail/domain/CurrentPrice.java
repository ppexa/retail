package com.demo.myretail.domain;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class CurrentPrice {

	private String price;
	private String currency;

}
