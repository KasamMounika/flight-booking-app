
package com.flightapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.model.AirLineDetails;
import com.flightapp.service.AddAirLineService;

/**
 * AdminController
 * 
 * @author Mounika
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1.0")
public class AddAirLineController {
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AddAirLineController.class);

	/**
	 * airLineService
	 */
	private transient final AddAirLineService airLineService;

	/**
	 * AddAirLineController constructor
	 * 
	 * @param airLineService
	 */
	public AddAirLineController(AddAirLineService airLineService) {
		this.airLineService = airLineService;
	}

	/**
	 * method to add airlines
	 * 
	 * @param airLineDetails
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/create/airlines")
	public ResponseEntity<?> createAirLine(@RequestBody final AirLineDetails airLineDetails) throws Exception {
		LOGGER.info("Inside createAirLine method");
		String status = airLineService.createAirLine(airLineDetails);
		LOGGER.info("Returning create new AirLine response");
		if (status != null) {
			if (status.equalsIgnoreCase("400")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400");
			}
			if (status.equalsIgnoreCase("600")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("600");
			}
			if (status.equalsIgnoreCase("601")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("601");
			}
			if (status.equalsIgnoreCase("602")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("602");
			}
			if (status.equalsIgnoreCase("603")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("603");
			}
			if (status.equalsIgnoreCase("604")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("604");
			}
			if (status.equalsIgnoreCase("605")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("605");
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body("200");
	}

	/**
	 * method to retrieve all airlines
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getAllAirLines")
	public ResponseEntity<?> getAllAirLines() throws Exception {
		LOGGER.info("Inside getAllAirLines method");
		LOGGER.info("Returning getAllAirLines response");
		return ResponseEntity.status(HttpStatus.OK).body(airLineService.getAllAirLines());
	}

	/**
	 * method to update airline status
	 * 
	 * @param airLineNumber
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/flight/updateFlightStatus/{airLineNumber}")
	public ResponseEntity<?> updateFlightStatus(@PathVariable final String airLineNumber,
			@RequestBody final String status) throws Exception {
		LOGGER.info("Inside updateFlightStatus method");
		LOGGER.info(airLineNumber);
		long airLineNo = Long.parseLong(airLineNumber);
		airLineService.updateFlightStatus(airLineNo, status);
		LOGGER.info("Returning updateFlightStatus response");
		return ResponseEntity.status(HttpStatus.OK).body("Air Line Status Updated Successfully...");
	}

	/**
	 * method to search for userflight
	 * 
	 * @param requestModel
	 * @return
	 */
	@PostMapping(value = "/flight/userSearch")
	public ResponseEntity<?> searchFlightForUser(@RequestBody final AirLineDetails airLineDetails) {
		LOGGER.info("Inside searchFlightForUser method");
		LOGGER.info("Returning searchFlightForUser response");

		if (airLineService.searchFlightForUser(airLineDetails) == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(airLineService.searchFlightForUser(airLineDetails));
	}

	/**
	 * method to update flight details
	 * 
	 * @param airLineDetails
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/flight/update")
	public ResponseEntity<?> updateFlightDetails(@RequestBody final AirLineDetails airLineDetails) throws Exception {
		LOGGER.info("Inside updateFlightDetails method");
		airLineService.updateFlightDetails(airLineDetails);
		LOGGER.info("Returning update flight details response");
		return ResponseEntity.status(HttpStatus.OK).body("Air Line Details Updated Successfully...");
	}

	/**
	 * method to retrieve all airlines
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getAllAirLinesForDiscount")
	public ResponseEntity<List<AddAirLineEntity>> getAllAirLinesForDiscount() throws Exception {
		LOGGER.info("Inside getAllAirLinesForDiscount method");
		LOGGER.info("Returning getAllAirLinesForDiscount response");
		return new ResponseEntity<>(airLineService.getAllAirLinesForDiscount(), HttpStatus.OK);
	}
}
