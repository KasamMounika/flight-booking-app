package com.flightapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * DiscountDetails
 * 
 * @author Mounika
 *
 */
@Component
@Entity
@Data
@Table(name = "disount_details")
public class DiscountDetailsEntity {

	/**
	 * discount_Code
	 */
	@Id
	@Column(name = "discountCode")
	private int discount_Code;
	/**
	 * flight_Number
	 */
	@Column(name = "flightNumber")
	private long flight_Number;

	/**
	 * discount_Offered
	 */
	@Column(name = "discountOffered")
	private int discount_Offered;

}
