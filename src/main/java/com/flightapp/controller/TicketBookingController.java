package com.flightapp.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.TicketBookingDetails;
import com.flightapp.service.TicketBookingService;

/**
 * TicketBookingController
 * 
 * @author Mounika
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1.0")
public class TicketBookingController {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketBookingController.class);

	/**
	 * ticketBookService
	 */
	private transient final TicketBookingService ticketBookService;

	/**
	 * Constructor injection
	 * 
	 * @param ticketBookingService
	 */
	public TicketBookingController(TicketBookingService ticketBookingService) {
		this.ticketBookService = ticketBookingService;
	}

	/**
	 * method to book ticket
	 * 
	 * @param ticketDetails
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/flight/booking")
	public ResponseEntity<?> bookFlightTicket(@RequestBody final TicketBookingDetails ticketDetails) throws Exception {
		LOGGER.info("Inside bookFlightTicket method");
		final String response = ticketBookService.bookFlightTicket(ticketDetails);
		LOGGER.info("Returning flight booking response");
		if (StringUtils.equals(response, "400")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400");
		} else if (StringUtils.equals(response, "603")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("603");
		} else if (StringUtils.equals(response, "600")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("600");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/**
	 * method to fetch ticket details
	 * 
	 * @param pnr
	 * @return
	 */
	@GetMapping(value = "/flight/ticket/{pnr}")
	public ResponseEntity<?> getTicketDetails(@PathVariable final int pnr) {
		LOGGER.info("Inside getTicketDetails method");
		LOGGER.info("Returning ticket details response");
		if (ticketBookService.getTicketDetails(pnr) == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ticketBookService.getTicketDetails(pnr));
	}

	/**
	 * method to get ticket history based on emailId
	 * 
	 * @param emailId
	 * @return
	 */
	@GetMapping(value = "/flight/tickets/{emailId}")
	public ResponseEntity<?> getTicketHistory(@PathVariable final String emailId) {
		LOGGER.info("Inside getTicketHistory method");
		LOGGER.info("Returning ticket history response");
		if (ticketBookService.getTicketHistory(emailId) == null) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ticketBookService.getTicketHistory(emailId));
	}

	/**
	 * method to cancel ticket
	 * 
	 * @param pnr
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(value = "/flight/cancel/{pnr}")
	public ResponseEntity<?> cancelTicket(@PathVariable final int pnr) throws Exception {
		LOGGER.info("Inside cancelTicket method");
		String cancelTicketStatus = ticketBookService.cancelTicket(pnr);
		LOGGER.info("Returning cancel ticket response");
		if (StringUtils.equals(cancelTicketStatus, "cancellation rejected")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cancellation rejected");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Your Flight Ticket Cancelled Successfully...");
	}

}
