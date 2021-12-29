
package com.flightapp.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.AddAirLineEntity;

/**
 * AddAirLineRepository
 * 
 * @author Mounika
 *
 */
@Repository
public interface AddAirLineRepository extends JpaRepository<AddAirLineEntity, Long> {

	/**
	 * method to retrieve flight details based date,on from and to place
	 */
	@Query(value = "Select a.*,d.* from air_line_booking a,disount_details d where a.from_place=:fromPlace and a.to_place=:toPlace and "
			+ "a.start_date=:date and a.round_trip_provided=:roundTrip and a.air_line_status='A' and a.air_line_number=d.flight_number", nativeQuery = true)
	List<Object> findForUser(@Param("fromPlace") String fromPlace, @Param("toPlace") String getToPlace,
			@Param("roundTrip") String getRoundTripDet, @Param("date") Date date);

	/**
	 * method to retrieve flight Id(s)
	 */
	@Query(value = "SELECT a.air_line_number " + "FROM hr.air_line_booking a "
			+ "    LEFT JOIN hr.disount_details d ON a.air_line_number=d.flight_number "
			+ "WHERE d.flight_number IS NULL", nativeQuery = true)
	List<Integer> findAllById();

}
