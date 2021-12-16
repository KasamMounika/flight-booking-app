
package com.flightapp.model;

import java.io.Serializable;
import java.sql.Date;

public class AirLineDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private long airLineNumber;
	private String airLineName;
	private String fromPlace;
	private String toPlace;
	private Date startDate;
	private String startTime;
	private Date endDate;
	private String endTime;
	private String scheduledDays;
	private String instrumentUsed;
	private int businessClassSeats;
	private int nonBusinessClassSeats;
	private String airLinePrice;
	private int totalRows;
	private String mealType;
	private long contactNumber;
	private String contactAddress;
	private String roundTripProvided;
	private String airLineStatus;

	public long getAirLineNumber() {
		return airLineNumber;
	}

	public void setAirLineNumber(long airLineNumber) {
		this.airLineNumber = airLineNumber;
	}

	public String getAirLineName() {
		return airLineName;
	}

	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getScheduledDays() {
		return scheduledDays;
	}

	public void setScheduledDays(String scheduledDays) {
		this.scheduledDays = scheduledDays;
	}

	public String getInstrumentUsed() {
		return instrumentUsed;
	}

	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}

	public int getBusinessClassSeats() {
		return businessClassSeats;
	}

	public void setBusinessClassSeats(int businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}

	public int getNonBusinessClassSeats() {
		return nonBusinessClassSeats;
	}

	public void setNonBusinessClassSeats(int nonBusinessClassSeats) {
		this.nonBusinessClassSeats = nonBusinessClassSeats;
	}

	public String getAirLinePrice() {
		return airLinePrice;
	}

	public void setAirLinePrice(String airLinePrice) {
		this.airLinePrice = airLinePrice;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getRoundTripProvided() {
		return roundTripProvided;
	}

	public void setRoundTripProvided(String roundTripProvided) {
		this.roundTripProvided = roundTripProvided;
	}

	public String getAirLineStatus() {
		return airLineStatus;
	}

	public void setAirLineStatus(String airLineStatus) {
		this.airLineStatus = airLineStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
