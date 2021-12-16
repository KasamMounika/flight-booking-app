
package com.flightapp.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.model.AirLineDetails;
import com.flightapp.repository.AddAirLineRepository;

@Service

@Component
public class AddAirLineService {

	private static final Logger logger = LoggerFactory.getLogger(AddAirLineService.class);

	@Autowired
	AddAirLineRepository airLineRepository;

	@Autowired
	AddAirLineEntity airLineEntity;

	public String createAirLine(AirLineDetails requestModel) {
		logger.info("Inside createAirLine service method");
		try {
			
			if(requestModel.getAirLineNumber()==0||StringUtils.isEmpty(requestModel.getAirLineName())||StringUtils.isEmpty(requestModel.getFromPlace())||StringUtils.isEmpty(requestModel.getToPlace())||
					requestModel.getStartDate()==null||requestModel.getEndDate()==null||StringUtils.isEmpty(requestModel.getScheduledDays())||StringUtils.isEmpty(requestModel.getInstrumentUsed())||
					requestModel.getBusinessClassSeats()==0||requestModel.getNonBusinessClassSeats()==0||StringUtils.isEmpty(requestModel.getAirLinePrice())||requestModel.getTotalRows()==0||StringUtils.isEmpty(requestModel.getMealType())
					||requestModel.getContactNumber()==0||StringUtils.isEmpty(requestModel.getContactAddress())||StringUtils.isEmpty(requestModel.getRoundTripProvided()))
			{
				return "400";
			}
			
			if(StringUtils.equals(requestModel.getFromPlace(), requestModel.getToPlace())) {
				return "600";
			}
			String currentDate = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis()));
			java.util.Date cdate= (new SimpleDateFormat("yyyy-MM-dd")).parse(currentDate);  
			
			if(requestModel.getStartDate().compareTo(cdate)<0 || (requestModel.getEndDate().compareTo(cdate)<0) ||
					(requestModel.getEndDate().compareTo(requestModel.getStartDate())<0)) {
				return "601";
			}
			
			airLineEntity.setAirLine_Number(requestModel.getAirLineNumber());
			airLineEntity.setAirLine_Name(requestModel.getAirLineName());
			airLineEntity.setFrom_Place(requestModel.getFromPlace());
			airLineEntity.setTo_Place(requestModel.getToPlace());
			airLineEntity.setStart_Date(requestModel.getStartDate());
			airLineEntity.setStart_Time("2:00PM");
			airLineEntity.setEnd_Date(requestModel.getEndDate());
			airLineEntity.setEnd_Time("4:00PM");
			airLineEntity.setScheduled_Days(requestModel.getScheduledDays());
			airLineEntity.setInstrument_Used(requestModel.getInstrumentUsed());
			airLineEntity.setBusiness_Class_Seats(requestModel.getBusinessClassSeats());
			airLineEntity.setNon_business_Class_Seats(requestModel.getNonBusinessClassSeats());
			airLineEntity.setAirLine_price(requestModel.getAirLinePrice());
			airLineEntity.setTotal_rows(requestModel.getTotalRows());
			airLineEntity.setMeal(requestModel.getMealType());
			airLineEntity.setContact_number(requestModel.getContactNumber());
			airLineEntity.setContact_address(requestModel.getContactAddress());
			airLineEntity.setRoundTrip_provided(requestModel.getRoundTripProvided());
			airLineEntity.setAirLine_Status("A");
			logger.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}

	public AddAirLineEntity searchFlight(long airLineNumber) {
		logger.info("Inside searchFlight service method");
		logger.info("Creating db query");
		Optional<AddAirLineEntity> obj = airLineRepository.findById(airLineNumber);
		logger.info("Returning flight search list");
		return obj.get();
	}

	public String updateFlightDetails(AirLineDetails requestModel) {
		logger.info("Inside updateFlightDetails service method");
		try {
			airLineEntity.setAirLine_Number(requestModel.getAirLineNumber());
			airLineEntity.setAirLine_Status(requestModel.getAirLineStatus());
			airLineEntity.setAirLine_Name(requestModel.getAirLineName());
			airLineEntity.setFrom_Place(requestModel.getFromPlace());
			airLineEntity.setTo_Place(requestModel.getToPlace());
			airLineEntity.setStart_Date(requestModel.getStartDate());
			airLineEntity.setEnd_Date(requestModel.getEndDate());
			airLineEntity.setInstrument_Used(requestModel.getInstrumentUsed());
			airLineEntity.setMeal(requestModel.getMealType());
			logger.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}
	
	public List<AddAirLineEntity> getAllAirLines() {
		logger.info("Inside getAllAirLines service method");
		logger.info("Creating db query");
		List<AddAirLineEntity> list = airLineRepository.findAll();
		logger.info("Returning flight details list");
		return list;
	}
	
	public String updateFlightStatus(long airLineNumber,String status) {
		logger.info("Inside updateFlightStatus service method");
		try {
			airLineEntity = searchFlight(airLineNumber);
			if(StringUtils.equalsIgnoreCase("A", status)) {
			airLineEntity.setAirLine_Status("I");
			}else {
				airLineEntity.setAirLine_Status("A");
			}
			logger.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}
	
	public List<AddAirLineEntity> searchFlightForUser(AirLineDetails requestModel) {
		logger.info("Inside searchFlightForUser service method");
		logger.info("Creating db query");
		if((StringUtils.equals(requestModel.getFromPlace(), requestModel.getToPlace()) || requestModel.getStartDate()==null)) {
			return null;
		}
		List<AddAirLineEntity> obj = airLineRepository.findForUser(requestModel.getFromPlace(),requestModel.getToPlace(),
				requestModel.getRoundTripProvided(),requestModel.getStartDate());
		logger.info("Returning flight search list");
		return obj;
	}

}
