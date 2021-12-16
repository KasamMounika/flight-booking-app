
  package com.flightapp.repository;
  
  
  
  import org.springframework.data.repository.CrudRepository; import
  org.springframework.stereotype.Repository;
  
  import com.flightapp.entity.FlightBookingEntity;
  
  
  @Repository public interface FlightBookingCrudRepository extends
  CrudRepository<FlightBookingEntity,Integer>{
  
  }
 