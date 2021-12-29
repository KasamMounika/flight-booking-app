package com.flightapp.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.entity.FlightBookingEntity;
import com.flightapp.model.TicketBookingDetails;
import com.flightapp.repository.AddAirLineRepository;
import com.flightapp.repository.FlightBookingRepository;

/**
 * TicketBookingService
 * 
 * @author Mounika
 *
 */
@Service
@Component
public class TicketBookingService {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketBookingService.class);

	/**
	 * repo
	 */
	FlightBookingRepository repo;

	/**
	 * entity
	 */
	FlightBookingEntity entity;
	/**
	 * airLineEntity
	 */
	AddAirLineEntity airLineEntity;
	/**
	 * airLinerepo
	 */
	AddAirLineRepository airLinerepo;

	/**
	 * TicketBookingService constructor dependency injection
	 * 
	 * @param repo
	 * @param crudRepo
	 * @param entity
	 */
	public TicketBookingService(FlightBookingRepository repo, FlightBookingEntity entity,
			AddAirLineRepository airLinerepo) {
		this.repo = repo;
		this.entity = entity;
		this.airLinerepo = airLinerepo;
	}

	/**
	 * method to book flight
	 * 
	 * @param ticketBookingDetails
	 * @return
	 */
	public String bookFlightTicket(final TicketBookingDetails ticketBookingDetails) {
		LOGGER.info("Inside bookFlightTicket service method");
		try {

			if (ticketBookingDetails.getFlightNumber() <= 0 || ticketBookingDetails.getEmailID() == null
					|| ticketBookingDetails.getNoOfSeatsToBook() <= 0 || ticketBookingDetails.getAge() <= 0
					|| ticketBookingDetails.getName() == null) {
				return "400";
			}
			if (ticketBookingDetails.getEmailID() != null) {
				Pattern ptrn = Pattern.compile("^(.+)@(.+)$");
				// the matcher() method creates a matcher that will match the given input
				// against this pattern
				Matcher match = ptrn.matcher(ticketBookingDetails.getEmailID());
				// returns a boolean value
				if (!(match.matches())) {
					return "603";
				}
			}
			long airlineNo = ticketBookingDetails.getFlightNumber();
			Optional<AddAirLineEntity> obj = airLinerepo.findById(airlineNo);
			int pnr = (int)Math.floor(Math.random()*(1000-1+1)+1);
			entity.setPnr(pnr);
			entity.setFlight_Number(ticketBookingDetails.getFlightNumber());
			entity.setDate(obj.get().getStart_Date());
			entity.setFrom_Place(obj.get().getFrom_Place());
			entity.setTo_Place(obj.get().getTo_Place());
			entity.setName(ticketBookingDetails.getName());
			entity.setEmailID(ticketBookingDetails.getEmailID());
			entity.setNo_Of_Seats_To_Book(ticketBookingDetails.getNoOfSeatsToBook());
			entity.setGender(ticketBookingDetails.getGender());
			entity.setAge(ticketBookingDetails.getAge());
			entity.setMealType(ticketBookingDetails.getMealType());
			entity.setSeatTypeSelected(ticketBookingDetails.getSeatTypeSelected());
			LOGGER.info("Creating db query");
			repo.save(entity);
			if (StringUtils.equals(entity.getSeatTypeSelected(), "Business class")) {
				obj.get()
						.setBusiness_Class_Seats(obj.get().getBusiness_Class_Seats() - entity.getNo_Of_Seats_To_Book());
				if (obj.get().getBusiness_Class_Seats() - entity.getNo_Of_Seats_To_Book() < 0) {
					return "600";
				}
			} else {
				obj.get().setNon_business_Class_Seats(
						obj.get().getNon_business_Class_Seats() - entity.getNo_Of_Seats_To_Book());
				if (obj.get().getBusiness_Class_Seats() - entity.getNo_Of_Seats_To_Book() < 0) {
					return "600";
				}
			}
			airLinerepo.save(obj.get());
		} catch (Exception e) {

			LOGGER.info("Exception occur" + e);
		}
		return String.valueOf(entity.getPnr());
	}

	/**
	 * method to fetch ticket details based on PNR
	 * 
	 * @param pnr
	 * @return
	 */
	public Optional<FlightBookingEntity> getTicketDetails(final int pnr) {
		LOGGER.info("Inside getTicketDetails service method");
		Optional<FlightBookingEntity> ticketBookDetails;
		LOGGER.info("Creating db query");
		ticketBookDetails = repo.findById(pnr);
		LOGGER.info("Returning db object");
		return ticketBookDetails;
	}

	/**
	 * method to get ticket details based on email ID
	 * 
	 * @param emailId
	 * @return
	 */
	public List<FlightBookingEntity> getTicketHistory(final String emailId) {
		LOGGER.info("Inside getTicketHistory service method");
		List<FlightBookingEntity> ticketHistoryDetails = new ArrayList<FlightBookingEntity>();
		LOGGER.info("Creating db query");
		ticketHistoryDetails = repo.findByEmailID(emailId);
		LOGGER.info("Returning db object");
		return ticketHistoryDetails;
	}

	/**
	 * method to cancel ticket based on PNR
	 * 
	 * @param pnr
	 * @return
	 */
	public String cancelTicket(int pnr) {
		LOGGER.info("Inside cancelTicket service method");
		try {
			Optional<FlightBookingEntity> ticketBookingDetails = getTicketDetails(pnr);
			String currentDate = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis()));
			java.util.Date cDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(currentDate);
			java.util.Date ticketBookedDate = (ticketBookingDetails.get().getDate());
			long diff = ticketBookedDate.getTime() - cDate.getTime();
			long diffHours = diff / (60 * 60 * 1000);

			if (diffHours <= 24) {
				repo.deleteById(pnr);
			} else {
				return "cancellation rejected";
			}
			LOGGER.info("Creating db query");

		} catch (Exception e) {
			LOGGER.info("Exception occur" + e);
		}
		return null;
	}

}
