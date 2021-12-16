
package com.flightapp.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.AddAirLineEntity;

@Repository
public interface AddAirLineRepository extends JpaRepository<AddAirLineEntity, Long> {

	@Query(value = "Select * from air_line_booking a where a.from_place=:fromPlace and a.to_place=:toPlace and "
			+ "a.start_date=:date and a.round_trip_provided=:roundTrip and a.air_line_status='A'",
			nativeQuery = true)
	List<AddAirLineEntity> findForUser(@Param("fromPlace") String fromPlace,@Param("toPlace") String getToPlace,
			@Param("roundTrip") String getRoundTripProvided,@Param("date") Date date);

}
