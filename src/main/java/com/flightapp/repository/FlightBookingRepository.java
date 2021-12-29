
package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.FlightBookingEntity;

/**
 * FlightBookingRepository
 * 
 * @author Mounika
 *
 */
@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity, Integer> {

	/**
	 * findByEmailID
	 * 
	 * @param emailId
	 * @return
	 */
	@Query(value = "Select * from flight_booking_details f WHERE f.emailid = :emailId", nativeQuery = true)
	List<FlightBookingEntity> findByEmailID(@Param("emailId") String emailId);
}
