package com.flightapp.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entity.FlightBookingEntity;

/**
 * TicketBookingServiceTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
public class TicketBookingServiceTest {

	/**
	 * ticketService
	 */
	TicketBookingService ticketService = Mockito.mock(TicketBookingService.class);

	/**
	 * fetchAllAirLinesTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void fetchAllAirLinesTest() throws Exception {
		final int pnr = 100;
		Optional<FlightBookingEntity> obj = ticketService.getTicketDetails(pnr);
		Mockito.when(ticketService.getTicketDetails(pnr)).thenReturn(obj);
	}
}
