package com.cognizant.fly.bean;

import com.cognizant.fly.exception.ApplicationException;
import com.cognizant.fly.exception.InvalidPassengerException;

public class ChildPassenger extends Passenger {

    /**
     * @param passengerElements
     * @throws InvalidPassengerException
     * @throws ApplicationException
     */
    public ChildPassenger(String[] passengerElements) throws InvalidPassengerException, ApplicationException {
        super(passengerElements);

    }

    /**
     * 
     * @return double
     */
    public double calculateTicketFare() {
        double ticketFare = this.getFlight().getChildFarePercentage() * (this.getFlight().getAdultFare() / 100);
        return ticketFare;

    }
}
