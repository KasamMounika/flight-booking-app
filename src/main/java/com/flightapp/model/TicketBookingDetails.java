
  package com.flightapp.model;
  
  import java.io.Serializable;
  
  public class TicketBookingDetails implements Serializable{
  
  private static final long serialVersionUID = 1L; private int pnr; private int
  flightNumber; private String date; private String fromPlace; private String
  toPlace; private String name; private String emailID; private int
  noOfSeatsToBook; private String gender; private int age; private String
  mealType;
  
  public int getPnr() { return pnr; } public void setPnr(int pnr) { this.pnr =
  pnr; } public int getFlightNumber() { return flightNumber; } public void
  setFlightNumber(int flightNumber) { this.flightNumber = flightNumber; }
  public String getDate() { return date; } public void setDate(String date) {
  this.date = date; } public String getFromPlace() { return fromPlace; } public
  void setFromPlace(String fromPlace) { this.fromPlace = fromPlace; } public
  String getToPlace() { return toPlace; } public void setToPlace(String
  toPlace) { this.toPlace = toPlace; } public String getName() { return name; }
  public void setName(String name) { this.name = name; } public String
  getEmailID() { return emailID; } public void setEmailID(String emailID) {
  this.emailID = emailID; } public int getNoOfSeatsToBook() { return
  noOfSeatsToBook; } public void setNoOfSeatsToBook(int noOfSeatsToBook) {
  this.noOfSeatsToBook = noOfSeatsToBook; } public String getGender() { return
  gender; } public void setGender(String gender) { this.gender = gender; }
  public int getAge() { return age; } public void setAge(int age) { this.age =
  age; } public String getMealType() { return mealType; } public void
  setMealType(String mealType) { this.mealType = mealType; } public static long
  getSerialversionuid() { return serialVersionUID; }
  
  }
 