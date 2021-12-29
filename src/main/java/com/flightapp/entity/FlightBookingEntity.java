
package com.flightapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * FlightBookingEntity
 * 
 * @author Mounika
 *
 */
@Component
@Entity
@Data
@Table(name = "flight_booking_details")
public class FlightBookingEntity {

	/**
	 * pnr
	 */
	@Id
	@Column(name = "pnr")
	private int pnr;

	/**
	 * flight_Number
	 */
	@Column(name = "flightNumber")
	private long flight_Number;

	/**
	 * date
	 */
	@Column(name = "date")
	private Date date;

	/**
	 * from_Place
	 */
	@Column(name = "fromPlace")
	private String from_Place;

	/**
	 * to_Place
	 */
	@Column(name = "toPlace")
	private String to_Place;

	/**
	 * name
	 */
	@Column(name = "name")
	private String name;

	/**
	 * emailID
	 */
	@Column(name = "emailID")
	private String emailID;

	/**
	 * no_Of_Seats_To_Book
	 */
	@Column(name = "noOfSeatsToBook")
	private int no_Of_Seats_To_Book;

	/**
	 * gender
	 */
	@Column(name = "gender")
	private String gender;

	/**
	 * age
	 */
	@Column(name = "age")
	private int age;

	/**
	 * mealType
	 */
	@Column(name = "mealType")
	private String mealType;

	/**
	 * seatTypeSelected
	 */
	@Column(name = "seatTypeSelected")
	private String seatTypeSelected;
}
