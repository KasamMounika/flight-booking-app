
package com.flightapp.model;

import java.io.Serializable;

import lombok.Data;

/**
 * UserLoginDetails
 * 
 * @author Mounika
 *
 */
@Data
public class UserLoginDetails implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3639895914302049622L;
	/**
	 * userID
	 */
	private long userID;
	/**
	 * userName
	 */
	private String userName;
	/**
	 * password
	 */
	private String password;
}
