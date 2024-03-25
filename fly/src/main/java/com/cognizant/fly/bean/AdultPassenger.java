package com.cognizant.fly.bean;

import com.cognizant.fly.exception.ApplicationException;
import com.cognizant.fly.exception.InvalidPassengerException;

public class AdultPassenger extends Passenger {

    /**
     * @param passengerElements
     * @throws InvalidPassengerException
     * @throws ApplicationException
     */
    public AdultPassenger(String[] passengerElements) throws InvalidPassengerException, ApplicationException {
        super(passengerElements);

    }

}
