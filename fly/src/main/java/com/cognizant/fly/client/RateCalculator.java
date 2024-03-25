package com.cognizant.fly.client;

import java.util.ArrayList;

import com.cognizant.fly.bean.Passenger;
import com.cognizant.fly.constants.ApplicationConstantsUtil;
import com.cognizant.fly.exception.ApplicationException;
import com.cognizant.fly.helper.FlightDetailsHelper;
import com.cognizant.fly.helper.PassengerDetailsHelper;

public class RateCalculator {

    /**
     * @throws ApplicationException
     */
    public static void processAndDisplayPassengerFares() throws ApplicationException {
        FlightDetailsHelper.getAllFlightDetails(ApplicationConstantsUtil.NEW_FLIGHT_FEED);
        ArrayList<Passenger> passengerList = PassengerDetailsHelper
                .getAllPassengers(ApplicationConstantsUtil.NEW_PASSENGER_FEED);
        calculateAndDisplayTicketFare(passengerList);
    }

    /**
     * @param passengerList
     * @throws ApplicationException
     */
    private static void calculateAndDisplayTicketFare(ArrayList<Passenger> passengerList) throws ApplicationException {

        Double flightFare = 0.0;
        for (int i = 0; i < passengerList.size()-1; i++) {
            Passenger passenger = passengerList.get(i);
            flightFare = passenger.calculateTicketFare();
            System.out.println("Ticket Fare for " + passenger.getPassengerId() + " = " + flightFare);
        }

    }

}
