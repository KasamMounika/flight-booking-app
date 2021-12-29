package com.flightapp.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.model.AirLineDetails;
import com.flightapp.service.AddAirLineService;

/**
 * AddAirLineControllerTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AddAirLineController.class)
public class AddAirLineControllerTest {

	/**
	 * mvc
	 */
	@Autowired
	private MockMvc mvc;

	/**
	 * service
	 */
	@MockBean
	private AddAirLineService service;

	/**
	 * getAllAirLinesTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAllAirLinesTest() throws Exception {
		final List<AddAirLineEntity> obj = service.getAllAirLines();
		given(service.getAllAirLines()).willReturn(obj);
		mvc.perform(get("/getAllAirLines").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}

	/**
	 * getAirLineDiscountTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAirLineDiscountTest() throws Exception {
		final List<AddAirLineEntity> obj = service.getAllAirLinesForDiscount();
		given(service.getAllAirLinesForDiscount()).willReturn(obj);
		mvc.perform(get("/getAllAirLinesForDiscount").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	/**
	 * updateFlightDetailsTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateFlightDetailsTest() throws Exception {
		final AirLineDetails airLineDetails = null;
		String obj = service.updateFlightDetails(airLineDetails);
		given(service.updateFlightDetails(airLineDetails)).willReturn(obj);
	}
}
