package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.entity.DiscountDetailsEntity;

/**
 * DiscountRepository
 * 
 * @author Mounika
 *
 */
public interface DiscountRepository extends JpaRepository<DiscountDetailsEntity, Integer> {

	/**
	 * method to retrieve discount
	 */
	@Query(value = "Select * from disount_details d WHERE d.flight_number = :airlineNo", nativeQuery = true)
	List<DiscountDetailsEntity> findDiscount(long airlineNo);
}
