package com.flightapp.controller;

import static org.mockito.BDDMockito.given;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entity.FlightBookingEntity;
import com.flightapp.service.TicketBookingService;

/**
 * TicketBookingControllerTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TicketBookingController.class)
public class TicketBookingControllerTest {

	/**
	 * TicketBookingService
	 */
	@MockBean
	private TicketBookingService service;

	/**
	 * ticketDetailsPNRTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void ticketDetailsPNRTest() throws Exception {
		final int pnr = 200;
		Optional<FlightBookingEntity> obj = service.getTicketDetails(pnr);
		given(service.getTicketDetails(pnr)).willReturn(obj);
	}

	/**
	 * ticketDetailsEmailTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void ticketDetailsEmailTest() throws Exception {
		final String email = "ll";
		List<FlightBookingEntity> obj = service.getTicketHistory(email);
		given(service.getTicketHistory(email)).willReturn(obj);
	}

}
