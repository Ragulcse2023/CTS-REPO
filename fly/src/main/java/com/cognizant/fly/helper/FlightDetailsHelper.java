package com.cognizant.fly.helper;

import java.util.ArrayList;
import java.util.HashMap;

import com.cognizant.fly.bean.Flight;
import com.cognizant.fly.constants.ApplicationConstantsUtil;
import com.cognizant.fly.exception.ApplicationException;
import com.cognizant.fly.util.ApplicationUtil;

public class FlightDetailsHelper {
    private static HashMap<String, Flight> flighDetails = new HashMap<String, Flight>();

    /**
     * @param inputFeed
     * @throws ApplicationException
     */
    public static void getAllFlightDetails(String inputFeed) throws ApplicationException {

        buildFlights(ApplicationUtil.readFile(inputFeed));
    }
    
    
    

    public static HashMap<String, Flight> getFlighDetails() {
		return flighDetails;
	}




	public static void setFlighDetails(HashMap<String, Flight> flighDetails) {
		FlightDetailsHelper.flighDetails = flighDetails;
	}




	/**
     * @param records
     * @throws ApplicationException
     */
    private static void buildFlights(ArrayList<String> records) throws ApplicationException {

        Flight flight = null;
        if (records == null || (records != null && records.size() == 0)) {
            throw new ApplicationException("Flight details feed not present");
        }

        for (int i = 0; i < records.size(); i++) {
            flight = new Flight();
            String[] flightElements = records.get(i).split(ApplicationConstantsUtil.NEW_FEED_DELIMITER);
            flight.setFlightId(flightElements[0]);
            flight.setAdultFare(Double.parseDouble(flightElements[1]));
            flight.setChildFarePercentage(Double.parseDouble(flightElements[2]));
            flighDetails.put(flight.getFlightId(), flight);
        }
    }

    /**
     * @param flightId
     * @return Flight
     */
    public static Flight getFlight(String flightId) {

        for (int i = 0; i < flighDetails.size(); i++) {

            if (flighDetails.get(flightId) != null)
                return flighDetails.get(flightId);

        }
        return null;
    }


}
