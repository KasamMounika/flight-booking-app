
package com.flightapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * AddAirLineEntity
 * 
 * @author Mounika
 *
 */
@Component
@Entity
@Data
@Table(name = "airLine_booking")
public class AddAirLineEntity {

	/**
	 * airLine_Number
	 */
	@Id
	@Column(name = "airLineNumber")
	private long airLine_Number;

	/**
	 * airLine_Name
	 */
	@Column(name = "airLineName")
	private String airLine_Name;

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
	 * start_Date
	 */
	@Column(name = "startDate")
	private Date start_Date;

	/**
	 * start_Time
	 */
	@Column(name = "startTime")
	private String start_Time;

	/**
	 * end_Date
	 */
	@Column(name = "endDate")
	private Date end_Date;

	/**
	 * end_Time
	 */
	@Column(name = "endTime")
	private String end_Time;

	/**
	 * scheduled_Days
	 */
	@Column(name = "scheduledDays")
	private String scheduled_Days;

	/**
	 * instrument_Used
	 */
	@Column(name = "instrumentUsed")
	private String instrument_Used;

	/**
	 * business_Class_Seats
	 */
	@Column(name = "businessClassSeats")
	private int business_Class_Seats;

	/**
	 * non_business_Class_Seats
	 */
	@Column(name = "nonBusinessClassSeats")
	private int non_business_Class_Seats;

	/**
	 * airLine_price
	 */
	@Column(name = "airLinePrice")
	private int airLine_price;

	/**
	 * total_rows
	 */
	@Column(name = "totalRows")
	private int total_rows;

	/**
	 * meal_Type
	 */
	@Column(name = "mealType")
	private String meal_Type;

	/**
	 * contact_number
	 */
	@Column(name = "contactNumber")
	private long contact_number;

	/**
	 * contact_address
	 */
	@Column(name = "contactAddress")
	private String contact_address;

	/**
	 * roundTrip_provided
	 */
	@Column(name = "roundTripProvided")
	private String roundTrip_provided;

	/**
	 * airLine_Status
	 */
	@Column(name = "airLineStatus")
	private String airLine_Status;

}
