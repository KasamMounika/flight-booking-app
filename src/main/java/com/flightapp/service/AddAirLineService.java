
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
import org.springframework.stereotype.Service;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.model.AirLineDetails;
import com.flightapp.repository.AddAirLineRepository;
import com.flightapp.repository.DiscountRepository;

/**
 * AddAirLineService
 * 
 * @author Mounika
 *
 */
@Service
public class AddAirLineService {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AddAirLineService.class);

	/**
	 * airLineRepository
	 */
	AddAirLineRepository airLineRepository;

	/**
	 * airLineEntity
	 */
	AddAirLineEntity airLineEntity;

	/**
	 * discountRepository
	 */
	DiscountRepository discountRepository;

	/**
	 * AddAirLineService
	 * 
	 * @param airLineRepository
	 * @param airLineEntity
	 */
	public AddAirLineService(AddAirLineRepository airLineRepository, AddAirLineEntity airLineEntity,
			DiscountRepository discountRepository) {
		this.airLineRepository = airLineRepository;
		this.airLineEntity = airLineEntity;
		this.discountRepository = discountRepository;
	}

	/**
	 * method used to insert airLineDetails
	 * 
	 * @param airLineDetails
	 * @return
	 */
	public String createAirLine(final AirLineDetails airLineDetails) {
		LOGGER.info("Inside createAirLine service method");
		try {

			if (airLineDetails.getAirLineNumber() <= 0 || StringUtils.isEmpty(airLineDetails.getAirLineName())
					|| StringUtils.isEmpty(airLineDetails.getFromPlace())
					|| StringUtils.isEmpty(airLineDetails.getToPlace()) || airLineDetails.getStartDate() == null
					|| airLineDetails.getEndDate() == null || StringUtils.isEmpty(airLineDetails.getScheduledDays())
					|| StringUtils.isEmpty(airLineDetails.getInstrumentUsed())
					|| airLineDetails.getBusinessClassSeats() <= 0 || airLineDetails.getNonBusinessClassSeats() <= 0
					|| airLineDetails.getAirLinePrice() <= 0 || airLineDetails.getTotalRows() <= 0
					|| StringUtils.isEmpty(airLineDetails.getMealType()) || airLineDetails.getContactNumber() <= 0
					|| StringUtils.isEmpty(airLineDetails.getContactAddress())
					|| StringUtils.isEmpty(airLineDetails.getRoundTripProvided())) {
				return "400";
			}

			if (StringUtils.equals(airLineDetails.getFromPlace(), airLineDetails.getToPlace())) {
				return "600";
			}
			String currentDate = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis()));
			java.util.Date cdate = (new SimpleDateFormat("yyyy-MM-dd")).parse(currentDate);

			if (airLineDetails.getStartDate().compareTo(cdate) < 0 || (airLineDetails.getEndDate().compareTo(cdate) < 0)
					|| (airLineDetails.getEndDate().compareTo(airLineDetails.getStartDate()) < 0)) {
				return "601";
			}

			if (airLineDetails.getContactNumber() >= 0) {
				Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
				// the matcher() method creates a matcher that will match the given input
				// against this pattern
				Matcher match = ptrn.matcher(String.valueOf(airLineDetails.getContactNumber()));
				// returns a boolean value
				if (!(match.find() && match.group().equals(String.valueOf(airLineDetails.getContactNumber())))) {
					return "602";
				}
			}

			if (airLineDetails.getContactAddress() != null) {
				Pattern ptrn = Pattern.compile("^(.+)@(.+)$");
				// the matcher() method creates a matcher that will match the given input
				// against this pattern
				Matcher match = ptrn.matcher(airLineDetails.getContactAddress());
				// returns a boolean value
				if (!(match.matches())) {
					return "603";
				}
			}

			if (airLineDetails.getBusinessClassSeats() > 100 || airLineDetails.getNonBusinessClassSeats() > 100) {
				return "604";
			}
			if (airLineDetails.getTotalRows() > 10) {
				return "605";
			}
			airLineEntity.setAirLine_Number(airLineDetails.getAirLineNumber());
			airLineEntity.setAirLine_Name(airLineDetails.getAirLineName());
			airLineEntity.setFrom_Place(airLineDetails.getFromPlace());
			airLineEntity.setTo_Place(airLineDetails.getToPlace());
			airLineEntity.setStart_Date(airLineDetails.getStartDate());
			airLineEntity.setStart_Time("2:00PM");
			airLineEntity.setEnd_Date(airLineDetails.getEndDate());
			airLineEntity.setEnd_Time("4:00PM");
			airLineEntity.setScheduled_Days(airLineDetails.getScheduledDays());
			airLineEntity.setInstrument_Used(airLineDetails.getInstrumentUsed());
			airLineEntity.setBusiness_Class_Seats(airLineDetails.getBusinessClassSeats());
			airLineEntity.setNon_business_Class_Seats(airLineDetails.getNonBusinessClassSeats());
			airLineEntity.setAirLine_price(airLineDetails.getAirLinePrice());
			airLineEntity.setTotal_rows(airLineDetails.getTotalRows());
			airLineEntity.setMeal_Type(airLineDetails.getMealType());
			airLineEntity.setContact_number(airLineDetails.getContactNumber());
			airLineEntity.setContact_address(airLineDetails.getContactAddress());
			airLineEntity.setRoundTrip_provided(airLineDetails.getRoundTripProvided());
			airLineEntity.setAirLine_Status("A");
			LOGGER.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			LOGGER.info("Exception occur" + e);
		}
		return null;
	}

	/**
	 * method used to search flight based on airLineNumber
	 * 
	 * @param airLineNumber
	 * @return
	 */
	public AddAirLineEntity searchFlight(final long airLineNumber) {
		LOGGER.info("Inside searchFlight service method");
		LOGGER.info("Creating db query");
		Optional<AddAirLineEntity> obj = airLineRepository.findById(airLineNumber);
		LOGGER.info("Returning flight search list");
		return obj.get();
	}

	/**
	 * method used to update airLineDetails
	 * 
	 * @param airLineDetails
	 * @return
	 */
	public String updateFlightDetails(final AirLineDetails airLineDetails) {
		LOGGER.info("Inside updateFlightDetails service method");
		try {
			airLineEntity.setAirLine_Number(airLineDetails.getAirLineNumber());
			airLineEntity.setAirLine_Status(airLineDetails.getAirLineStatus());
			airLineEntity.setAirLine_Name(airLineDetails.getAirLineName());
			airLineEntity.setFrom_Place(airLineDetails.getFromPlace());
			airLineEntity.setTo_Place(airLineDetails.getToPlace());
			airLineEntity.setStart_Date(airLineDetails.getStartDate());
			airLineEntity.setEnd_Date(airLineDetails.getEndDate());
			airLineEntity.setInstrument_Used(airLineDetails.getInstrumentUsed());
			airLineEntity.setMeal_Type(airLineDetails.getMealType());
			LOGGER.info("Creating db query");
			airLineRepository.save(airLineEntity);
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
	public List<AddAirLineEntity> getAllAirLines() {
		LOGGER.info("Inside getAllAirLines service method");
		LOGGER.info("Creating db query");
		List<AddAirLineEntity> list = airLineRepository.findAll();
		LOGGER.info("Returning flight details list");
		return list;
	}

	/**
	 * method used to update flight status
	 * 
	 * @param airLineNumber
	 * @param status
	 * @return
	 */
	public String updateFlightStatus(final long airLineNumber, final String status) {
		LOGGER.info("Inside updateFlightStatus service method");
		try {
			airLineEntity = searchFlight(airLineNumber);
			if (StringUtils.equalsIgnoreCase("A", status)) {
				airLineEntity.setAirLine_Status("I");
			} else {
				airLineEntity.setAirLine_Status("A");
			}
			LOGGER.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			LOGGER.info("Exception occur" + e);
		}
		return null;
	}

	/**
	 * method used to search airLineDetails
	 * 
	 * @param airLineDetails
	 * @return
	 */
	public List<Object> searchFlightForUser(final AirLineDetails airLineDetails) {
		LOGGER.info("Inside searchFlightForUser service method");
		LOGGER.info("Creating db query");
		if ((StringUtils.equals(airLineDetails.getFromPlace(), airLineDetails.getToPlace())
				|| airLineDetails.getStartDate() == null)) {
			return null;
		}
		List<Object> objAirLineDetails = airLineRepository.findForUser(airLineDetails.getFromPlace(),
				airLineDetails.getToPlace(), airLineDetails.getRoundTripProvided(), airLineDetails.getStartDate());
		LOGGER.info("Returning flight search list");
		return objAirLineDetails;
	}

	/**
	 * method to retrieve airLine details
	 * 
	 * @return
	 */
	public List<AddAirLineEntity> getAllAirLinesForDiscount() {
		LOGGER.info("Inside getAllAirLinesForDiscount service method");
		LOGGER.info("Creating db query");
		List<AddAirLineEntity> listForDiscount = new ArrayList<AddAirLineEntity>();
		List<AddAirLineEntity> list = airLineRepository.findAll();
		List<Integer> airLineList = airLineRepository.findAllById();
		list.forEach(obj -> {
			airLineList.forEach(id -> {
				if (id == obj.getAirLine_Number()) {
					listForDiscount.add(obj);
				}
			});
		});
		LOGGER.info("Returning getAllAirLinesForDiscount list");
		return listForDiscount;
	}
}
