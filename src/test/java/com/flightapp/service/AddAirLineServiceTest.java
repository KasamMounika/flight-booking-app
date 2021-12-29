package com.flightapp.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entity.AddAirLineEntity;

/**
 * AddAirLineServiceTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
public class AddAirLineServiceTest {
	/**
	 * addAirLineService
	 */
	AddAirLineService addAirLineService = Mockito.mock(AddAirLineService.class);

	/**
	 * getAllAirLinesTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void fetchAllAirLinesTest() throws Exception {
		final List<AddAirLineEntity> obj = addAirLineService.getAllAirLines();
		Mockito.when(addAirLineService.getAllAirLines()).thenReturn(obj);
	}
}
