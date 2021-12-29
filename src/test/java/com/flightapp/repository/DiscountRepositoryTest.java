package com.flightapp.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entity.DiscountDetailsEntity;

/**
 * DiscountRepositoryTest
 * 
 * @author Mounika
 *
 */
@RunWith(SpringRunner.class)
public class DiscountRepositoryTest {

	/**
	 * discountRepository
	 */
	DiscountRepository discountRepository = Mockito.mock(DiscountRepository.class);

	/**
	 * findDiscountTest
	 */
	@Test
	public void findDiscountTest() {

		// when
		final List<DiscountDetailsEntity> obj = discountRepository.findDiscount(200);

		// then
		assertNotNull(obj);

	}

}