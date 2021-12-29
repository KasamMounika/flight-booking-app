
package com.flightapp.model;

import java.io.Serializable;

import lombok.Data;

/**
 * TicketBookingDetails
 * 
 * @author Mounika
 *
 */
@Data
public class TicketBookingDetails implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * pnr
	 */
	private int pnr;
	/**
	 * flightNumber
	 */
	private int flightNumber;
	/**
	 * date
	 */
	private String date;
	/**
	 * fromPlace
	 */
	private String fromPlace;
	/**
	 * toPlace
	 */
	private String toPlace;
	/**
	 * name
	 */
	private String name;
	/**
	 * emailID
	 */
	private String emailID;
	/**
	 * noOfSeatsToBook
	 */
	private int noOfSeatsToBook;
	/**
	 * gender
	 */
	private String gender;
	/**
	 * age
	 */
	private int age;
	/**
	 * mealType
	 */
	private String mealType;
	/**
	 * seatTypeSelected
	 */
	private String seatTypeSelected;

}
