package com.flightapp.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entity.FlightBookingEntity;

/**
 * FlightBookingRepositoryTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
public class FlightBookingRepositoryTest {

	/**
	 * flightBookingRepository
	 */
	FlightBookingRepository flightBookRepo = Mockito.mock(FlightBookingRepository.class);

	/**
	 * returnFlightBooking
	 */
	@Test
	public void returnFlightBooking() {

		// when
		final List<FlightBookingEntity> obj = flightBookRepo.findByEmailID(null);

		// then
		assertNotNull(obj);

	}

}