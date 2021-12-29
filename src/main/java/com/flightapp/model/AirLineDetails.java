
package com.flightapp.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * AirLineDetails
 * 
 * @author Mounika
 *
 */
@Data
public class AirLineDetails implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * airLineNumber
	 */
	private long airLineNumber;
	/**
	 * airLineName
	 */
	private String airLineName;
	/**
	 * fromPlace
	 */
	private String fromPlace;
	/**
	 * toPlace
	 */
	private String toPlace;
	/**
	 * startDate
	 */
	private Date startDate;
	/**
	 * startTime
	 */
	private String startTime;
	/**
	 * endDate
	 */
	private Date endDate;
	/**
	 * endTime
	 */
	private String endTime;
	/**
	 * scheduledDays
	 */
	private String scheduledDays;
	/**
	 * instrumentUsed
	 */
	private String instrumentUsed;
	/**
	 * businessClassSeats
	 */
	private int businessClassSeats;
	/**
	 * nonBusinessClassSeats
	 */
	private int nonBusinessClassSeats;
	/**
	 * airLinePrice
	 */
	private int airLinePrice;
	/**
	 * totalRows
	 */
	private int totalRows;
	/**
	 * mealType
	 */
	private String mealType;
	/**
	 * contactNumber
	 */
	private long contactNumber;
	/**
	 * contactAddress
	 */
	private String contactAddress;
	/**
	 * roundTripProvided
	 */
	private String roundTripProvided;
	/**
	 * airLineStatus
	 */
	private String airLineStatus;

}
