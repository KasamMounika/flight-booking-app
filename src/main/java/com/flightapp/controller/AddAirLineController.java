
package com.flightapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1.0")
public class AddAirLineController {

	private static final Logger logger = LoggerFactory.getLogger(AddAirLineController.class);

	@Autowired
	AddAirLineService airLineService;

	@PostMapping(value = "/create/airlines")
	public ResponseEntity<String> createAirLine(@RequestBody AirLineDetails requestModel) throws Exception {
		logger.info("Inside createAirLine method");
		String status = airLineService.createAirLine(requestModel);
		logger.info("Returning create new AirLine response");
		if(status!=null) {
		if(status.equalsIgnoreCase("400")) {
			return new ResponseEntity<>("400", HttpStatus.BAD_REQUEST);
		}
		if(status.equalsIgnoreCase("600")) {
			return new ResponseEntity<>("600", HttpStatus.BAD_REQUEST);
		}
		if(status.equalsIgnoreCase("601")) {
			return new ResponseEntity<>("601", HttpStatus.BAD_REQUEST);
		}
		}
		return new ResponseEntity<>("New Air Line Created Successfully...", HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllAirLines")
	public ResponseEntity<List<AddAirLineEntity>> getAllAirLines() throws Exception {
		logger.info("Inside getAllAirLines method");
		logger.info("Returning getAllAirLines response");
		return new ResponseEntity<>(airLineService.getAllAirLines(), HttpStatus.OK);
	}

	@PutMapping(value = "/flight/updateFlightStatus/{airLineNumber}")
	public ResponseEntity<String> updateFlightStatus(@PathVariable String airLineNumber,@RequestBody String status) throws Exception {
		logger.info("Inside updateFlightStatus method");
		System.out.println(airLineNumber);
		long airLineNo = Long.parseLong(airLineNumber);
		airLineService.updateFlightStatus(airLineNo,status);
		logger.info("Returning updateFlightStatus response");
		return new ResponseEntity<>("Air Line Status Updated Successfully...", HttpStatus.OK);
	}
	
	@PostMapping(value = "/flight/userSearch")
	public ResponseEntity<List<AddAirLineEntity>> searchFlightForUser(@RequestBody AirLineDetails requestModel) {
		logger.info("Inside searchFlightForUser method");
		logger.info("Returning searchFlightForUser response");
		
		if(airLineService.searchFlightForUser(requestModel)==null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(airLineService.searchFlightForUser(requestModel), HttpStatus.OK);
	}

	@PutMapping(value = "/flight/update")
	public ResponseEntity<String> updateFlightDetails(@RequestBody AirLineDetails requestModel) throws Exception {
		logger.info("Inside updateFlightDetails method");
		airLineService.updateFlightDetails(requestModel);
		logger.info("Returning update flight details response");
		return new ResponseEntity<>("Air Line Details Updated Successfully...", HttpStatus.OK);
	}

}
