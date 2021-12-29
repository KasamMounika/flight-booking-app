package com.flightapp.controller;

import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entity.DiscountDetailsEntity;
import com.flightapp.service.DiscountHandlerService;

/**
 * DiscountHandlerControllerTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DiscountHandlerController.class)
public class DiscountHandlerControllerTest {

	/**
	 * service
	 */
	@MockBean
	private DiscountHandlerService service;

	/**
	 * getDiscountDetails
	 * 
	 * @throws Exception
	 */
	@Test
	public void getDiscountDetails() throws Exception {
		long airlineNo = 200;
		List<DiscountDetailsEntity> obj = service.getDiscount(airlineNo);
		given(service.getDiscount(airlineNo)).willReturn(obj);
	}

}
