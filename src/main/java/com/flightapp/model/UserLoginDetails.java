
  package com.flightapp.model;
  
  import java.io.Serializable;
  
  public class UserLoginDetails implements Serializable{
  
  private static final long serialVersionUID = 3639895914302049622L; private
  long userID; private String userName; private String password;
  
  public long getUserID() { return userID; } public void setUserID(long userID)
  { this.userID = userID; } public String getUserName() { return userName; }
  public void setUserName(String userName) { this.userName = userName; } public
  String getPassword() { return password; } public void setPassword(String
  password) { this.password = password; } public static long
  getSerialversionuid() { return serialVersionUID; }
  
  }
 