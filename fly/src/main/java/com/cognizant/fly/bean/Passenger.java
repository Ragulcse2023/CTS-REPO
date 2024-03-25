package com.cognizant.fly.bean;

import com.cognizant.fly.exception.ApplicationException;
import com.cognizant.fly.exception.InvalidPassengerException;
import com.cognizant.fly.helper.FlightDetailsHelper;
import com.cognizant.fly.util.ApplicationUtil;

public class Passenger {

    private Integer id;
    private String passengerId;
    private String passengerName;
    private String passengerType;
    private String flightId;
    private Flight flight;

    /**
     * @return Flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @param flight
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    
    public Passenger()
    {
    	
    }

    /**
     * @param passengerElements
     * @throws InvalidPassengerException
     * @throws ApplicationException
     */
    public Passenger(String[] passengerElements) throws InvalidPassengerException, ApplicationException {
        super();
        Flight flightDetails = FlightDetailsHelper.getFlight(passengerElements[3]);

        if (!ApplicationUtil.isValidPassengerId(passengerElements[0])) {
            throw new InvalidPassengerException("Passenger id is not valid - " + passengerElements[0]);
        } else if (flightDetails == null) {
            throw new InvalidPassengerException(
                    "Flight id for - " + passengerElements[0] + " is not present in the feed");
        }

        this.passengerId = passengerElements[0];
        this.passengerName = passengerElements[1];
        this.passengerType = passengerElements[2];
        this.flightId = passengerElements[3];
        this.flight = flightDetails;
    }

    /**
     * @return passengerId
     */
    public String getPassengerId() {
        return passengerId;
    }

    /**
     * @param passengerId
     */
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * @return flightId
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * @param flightId
     */
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    /**
     * @return passengerName
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * @param passengerName
     */
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    /**
     * @return passengerType
     */
    public String getPassengerType() {
        return passengerType;
    }

    /**
     * @param passengerType
     */
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    @Override
    public String toString() {
        return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerType="
                + passengerType +"]";
    }

    /**
     * @return double
     */
    public double calculateTicketFare() {
        return this.getFlight().getAdultFare();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
