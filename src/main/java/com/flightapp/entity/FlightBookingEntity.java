
  package com.flightapp.entity;
  
  import javax.persistence.Column; import javax.persistence.Entity; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.Table;
  
  import org.springframework.stereotype.Component;
  
  @Entity
  
  @Component
  
  @Table(name = "flight_booking") public class FlightBookingEntity {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO)
  
  @Column(name="PNR") private int pnr;
  
  @Column(name="FlightNumber") private int flight_Number;
  
  @Column(name="Date") private String date;
  
  @Column(name="FromPlace") private String from_Place;
  
  @Column(name="ToPlace") private String to_Place;
  
  @Column(name="Name") private String name;
  
  @Column(name="EmailID") private String emailID;
  
  @Column(name="NoOfSeatsToBook") private int no_Of_Seats_To_Book;
  
  @Column(name="Gender") private String gender;
  
  @Column(name="Age") private int age;
  
  @Column(name="MealType") private String mealType;
  
  public int getPnr() { return pnr; }
  
  public void setPnr(int pnr) { this.pnr = pnr; }
  
  public int getFlight_Number() { return flight_Number; }
  
  public void setFlight_Number(int flight_Number) { this.flight_Number =
  flight_Number; }
  
  public String getDate() { return date; }
  
  public void setDate(String date) { this.date = date; }
  
  public String getFrom_Place() { return from_Place; }
  
  public void setFrom_Place(String from_Place) { this.from_Place = from_Place;
  }
  
  public String getTo_Place() { return to_Place; }
  
  public void setTo_Place(String to_Place) { this.to_Place = to_Place; }
  
  public String getName() { return name; }
  
  public void setName(String name) { this.name = name; }
  
  public String getEmailID() { return emailID; }
  
  public void setEmailID(String emailID) { this.emailID = emailID; }
  
  public int getNo_Of_Seats_To_Book() { return no_Of_Seats_To_Book; }
  
  public void setNo_Of_Seats_To_Book(int no_Of_Seats_To_Book) {
  this.no_Of_Seats_To_Book = no_Of_Seats_To_Book; }
  
  public String getGender() { return gender; }
  
  public void setGender(String gender) { this.gender = gender; }
  
  public int getAge() { return age; }
  
  public void setAge(int age) { this.age = age; }
  
  public String getMealType() { return mealType; }
  
  public void setMealType(String mealType) { this.mealType = mealType; }
  
  }
 