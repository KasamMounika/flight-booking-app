
  package com.flightapp.repository;
  
  
  import java.util.List;
  
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.data.jpa.repository.Query; import
  org.springframework.data.repository.query.Param; import
  org.springframework.stereotype.Repository;
  
  import com.flightapp.entity.FlightBookingEntity;
  
  
  @Repository public interface FlightBookingRepository extends
  JpaRepository<FlightBookingEntity,Integer>{
  
  @Query(value="Select * from flight_booking f WHERE f.emailId = :emailId"
  ,nativeQuery=true) List<FlightBookingEntity> findByEmailID(@Param("emailId")
  String emailId);
  
  //Optional<FlightBookingEntity> getById(String emailId);
  
  //Optional<FlightBookingEntity> findById(String emailId);
  
  //List<TicketBookingDetails> findAllById(int val);
  
  }
 