package com.flightapp.model;

import lombok.Data;

@Data
public class DiscountDetails {

	/**
	 * flight_Number
	 */
	private String flight_Number;

	/**
	 * discount_Code
	 */
	private String discount_Code;

	/**
	 * discount_Offered
	 */
	private String discount_Offered;

}
