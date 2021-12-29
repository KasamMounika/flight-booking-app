package com.flightapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.DiscountDetails;
import com.flightapp.service.DiscountHandlerService;

/**
 * DiscountHandlerController
 * 
 * @author Mounika
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1.0")
public class DiscountHandlerController {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscountHandlerController.class);

	/**
	 * discountService
	 */
	private final transient DiscountHandlerService discountService;

	/**
	 * AddAirLineController constructor
	 * 
	 * @param airLineService
	 */
	public DiscountHandlerController(DiscountHandlerService discountHandlerService) {
		this.discountService = discountHandlerService;
	}

	/**
	 * method to create airlines
	 * 
	 * @param airLineDetails
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/create/discountDetails")
	public ResponseEntity<?> addDiscountDetails(@RequestBody final DiscountDetails discountDetails) throws Exception {
		LOGGER.info("Inside addDiscountDetails method");
		String status = discountService.addDiscountDetails(discountDetails);
		LOGGER.info("Returning addDiscountDetails response");
		if (status != null) {
			if (status.equalsIgnoreCase("400")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400");
			}
			if (status.equalsIgnoreCase("600")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("600");
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body("200");
	}

	/**
	 * method to retrieve discount based on ID
	 * 
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getDiscount/{airLineNumber}")
	public ResponseEntity<?> getDiscount(@PathVariable final String airLineNumber) throws Exception {
		LOGGER.info("Inside getDiscount method");
		final long airLineNo = Long.parseLong(airLineNumber);
		LOGGER.info("Returning getDiscount response");
		return ResponseEntity.status(HttpStatus.OK).body(discountService.getDiscount(airLineNo));
	}

}
