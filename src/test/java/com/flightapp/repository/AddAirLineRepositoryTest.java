package com.flightapp.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * AddAirLineRepositoryTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
public class AddAirLineRepositoryTest {

	/**
	 * airLineRepository
	 */
	AddAirLineRepository airLineRepository = Mockito.mock(AddAirLineRepository.class);

	/**
	 * findAllByIdTest
	 */
	@Test
	public void findAllByIdTest() {

		// when
		final List<Integer> obj = airLineRepository.findAllById();

		// then
		assertNotNull(obj);

	}

}