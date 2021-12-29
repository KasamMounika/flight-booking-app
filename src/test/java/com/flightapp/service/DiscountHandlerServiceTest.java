package com.flightapp.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entity.DiscountDetailsEntity;

/**
 * DiscountHandlerServiceTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
public class DiscountHandlerServiceTest {

	/**
	 * discountService
	 */
	DiscountHandlerService discountService = Mockito.mock(DiscountHandlerService.class);

	/**
	 * getDiscountDetailsTest
	 * 
	 * @throws Exception
	 */
	@Test
	public void fetchDiscountDetailsTest() throws Exception {
		final long airLineNumber = 100;
		List<DiscountDetailsEntity> obj = discountService.getDiscount(airLineNumber);
		Mockito.when(discountService.getDiscount(airLineNumber)).thenReturn(obj);
	}
}
