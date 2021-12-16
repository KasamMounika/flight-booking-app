
package com.flightapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity

@Component

@Table(name = "airLine_booking")
public class AddAirLineEntity {

	@Id
	@Column(name = "airLineNumber")
	private long airLine_Number;

	@Column(name = "airLineName")
	private String airLine_Name;

	@Column(name = "fromPlace")
	private String from_Place;

	@Column(name = "toPlace")
	private String to_Place;

	@Column(name = "startDate")
	private Date start_Date;

	@Column(name = "startTime")
	private String start_Time;

	@Column(name = "endDate")
	private Date end_Date;

	@Column(name = "endTime")
	private String end_Time;

	@Column(name = "scheduledDays")
	private String scheduled_Days;

	@Column(name = "instrumentUsed")
	private String instrument_Used;

	@Column(name = "businessClassSeats")
	private int business_Class_Seats;

	@Column(name = "nonBusinessClassSeats")
	private int non_business_Class_Seats;

	@Column(name = "airLinePrice")
	private String airLine_price;

	@Column(name = "totalRows")
	private int total_rows;

	@Column(name = "mealType")
	private String meal_Type;

	@Column(name = "contactNumber")
	private long contact_number;

	@Column(name = "contactAddress")
	private String contact_address;

	@Column(name = "roundTripProvided")
	private String roundTrip_provided;

	@Column(name = "airLineStatus")
	private String airLine_Status;

	public long getAirLine_Number() {
		return airLine_Number;
	}

	public void setAirLine_Number(long airLine_Number) {
		this.airLine_Number = airLine_Number;
	}

	public String getAirLine_Name() {
		return airLine_Name;
	}

	public void setAirLine_Name(String airLine_Name) {
		this.airLine_Name = airLine_Name;
	}

	public String getFrom_Place() {
		return from_Place;
	}

	public void setFrom_Place(String from_Place) {
		this.from_Place = from_Place;
	}

	public String getTo_Place() {
		return to_Place;
	}

	public void setTo_Place(String to_Place) {
		this.to_Place = to_Place;
	}

	public Date getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public String getStart_Time() {
		return start_Time;
	}

	public void setStart_Time(String start_Time) {
		this.start_Time = start_Time;
	}

	public Date getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}

	public String getEnd_Time() {
		return end_Time;
	}

	public void setEnd_Time(String end_Time) {
		this.end_Time = end_Time;
	}

	public String getScheduled_Days() {
		return scheduled_Days;
	}

	public void setScheduled_Days(String scheduled_Days) {
		this.scheduled_Days = scheduled_Days;
	}

	public String getInstrument_Used() {
		return instrument_Used;
	}

	public void setInstrument_Used(String instrument_Used) {
		this.instrument_Used = instrument_Used;
	}

	public int getBusiness_Class_Seats() {
		return business_Class_Seats;
	}

	public void setBusiness_Class_Seats(int business_Class_Seats) {
		this.business_Class_Seats = business_Class_Seats;
	}

	public int getNon_business_Class_Seats() {
		return non_business_Class_Seats;
	}

	public void setNon_business_Class_Seats(int non_business_Class_Seats) {
		this.non_business_Class_Seats = non_business_Class_Seats;
	}

	public String getAirLine_price() {
		return airLine_price;
	}

	public void setAirLine_price(String airLine_price) {
		this.airLine_price = airLine_price;
	}

	public int getTotal_rows() {
		return total_rows;
	}

	public void setTotal_rows(int total_rows) {
		this.total_rows = total_rows;
	}

	public String getMeal() {
		return meal_Type;
	}

	public void setMeal(String meal) {
		this.meal_Type = meal;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public String getContact_address() {
		return contact_address;
	}

	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}

	public String getRoundTrip_provided() {
		return roundTrip_provided;
	}

	public void setRoundTrip_provided(String roundTrip_provided) {
		this.roundTrip_provided = roundTrip_provided;
	}

	public String getAirLine_Status() {
		return airLine_Status;
	}

	public void setAirLine_Status(String airLine_Status) {
		this.airLine_Status = airLine_Status;
	}

}
