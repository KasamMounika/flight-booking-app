
  package com.flightapp.controller;
  
  
  import java.util.List; import java.util.Optional;
  
  import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.HttpStatus; import
  org.springframework.http.ResponseEntity; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RestController;
  
  
  import com.flightapp.entity.FlightBookingEntity; import
  com.flightapp.model.TicketBookingDetails; import
  com.flightapp.service.TicketBookingService;
  
  
  @RestController
  
  @RequestMapping(value="/api/v1.0") public class TicketBookingController {
  
  private static final Logger logger =
  LoggerFactory.getLogger(TicketBookingController.class);
  
  @Autowired TicketBookingService ticketBookingService;
  
  @PostMapping(value = "/flight/booking") public ResponseEntity<String>
  bookFlightTicket(@RequestBody TicketBookingDetails requestModel) throws
  Exception { logger.info("Inside bookFlightTicket method");
  ticketBookingService.bookFlightTicket(requestModel);
  logger.info("Returning flight booking response"); return new
  ResponseEntity<>("Your Flight Booked Successfully...",HttpStatus.OK); }
  
  @GetMapping(value ="/flight/ticket/{pnr}") public
  Optional<FlightBookingEntity> getTicketDetails(@PathVariable int pnr) {
  logger.info("Inside getTicketDetails method");
  logger.info("Returning ticket details response"); return
  ticketBookingService.getTicketDetails(pnr); }
  
  @GetMapping(value ="/flight/tickets/{emailId}") public
  List<FlightBookingEntity> getTicketHistory(@PathVariable String emailId) {
  logger.info("Inside getTicketHistory method");
  logger.info("Returning ticket history response"); return
  ticketBookingService.getTicketHistory(emailId); }
  
  @DeleteMapping(value="/flight/cancel/{pnr}") public ResponseEntity<String>
  cancelTicket(@PathVariable int pnr) throws Exception {
  logger.info("Inside cancelTicket method");
  ticketBookingService.cancelTicket(pnr);
  logger.info("Returning cancel ticket response"); return new
  ResponseEntity<>("Your Flight Ticket Cancelled Successfully...",HttpStatus.OK
  ); }
  
  }
 