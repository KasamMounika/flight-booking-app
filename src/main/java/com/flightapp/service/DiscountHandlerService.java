package com.flightapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.flightapp.entity.DiscountDetailsEntity;
import com.flightapp.model.DiscountDetails;
import com.flightapp.repository.DiscountRepository;

/**
 * 
 * @author Mounika
 *
 */
@Service
public class DiscountHandlerService {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscountHandlerService.class);

	/**
	 * discountRepository
	 */
	DiscountRepository discountRepository;
	/**
	 * DiscountDetailsEntity
	 */
	DiscountDetailsEntity discountDetEntity;

	/**
	 * Constructor injection
	 * 
	 * @param discountRepository
	 * @param discountDetailsEntity
	 */
	public DiscountHandlerService(DiscountRepository discountRepository, DiscountDetailsEntity discountDetailsEntity) {
		this.discountRepository = discountRepository;
		this.discountDetEntity = discountDetailsEntity;
	}

	/**
	 * method used to insert discountDetails
	 * 
	 * @param airLineDetails
	 * @return
	 */
	public String addDiscountDetails(final DiscountDetails discountDetails) {
		LOGGER.info("Inside addDiscountDetails service method");
		try {
			final List<DiscountDetailsEntity> list = discountRepository.findAll();
			final int discount = Integer.parseInt(discountDetails.getDiscount_Code());
			Optional<DiscountDetailsEntity> codeFound = list.stream().filter(p -> p.getDiscount_Code() == discount) // filtering
																													// price
					.findAny();

			if (codeFound == null) {
				return "600";
			}
			discountDetEntity.setFlight_Number(Long.parseLong(discountDetails.getFlight_Number()));
			discountDetEntity.setDiscount_Code(Integer.parseInt(discountDetails.getDiscount_Code()));
			discountDetEntity.setDiscount_Offered(Integer.parseInt(discountDetails.getDiscount_Offered()));
			LOGGER.info("Creating db query");
			discountRepository.save(discountDetEntity);
		} catch (Exception e) {
			LOGGER.info("Exception occur" + e);
		}
		return null;
	}

	/**
	 * method to retrieve airLine details
	 * 
	 * @return
	 */
	public List<DiscountDetailsEntity> getDiscount(final long airLineNo) {
		LOGGER.info("Inside getAllAirLines service method");
		LOGGER.info("Creating db query");
		final List<DiscountDetailsEntity> list = discountRepository.findDiscount(airLineNo);
		LOGGER.info("Returning flight details list");
		return list;
	}
}
