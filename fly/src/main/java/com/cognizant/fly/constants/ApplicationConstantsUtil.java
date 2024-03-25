package com.cognizant.fly.constants;

public class ApplicationConstantsUtil {

    public static final String NEW_PASSENGER_FEED = "./feed/passengerDetails.csv";
    public static final String NEW_FLIGHT_FEED = "./feed/flightDetails.csv";
    public static final String NEW_FEED_DELIMITER = ",";
    public static final String PASSENGERID_PREFIX = "PA";
    
    
    public static final String INSERT_FLIGHT_SQL = "INSERT INTO flight " + "VALUES" + " (?, ?, ?);";
    
    
    public static final String INSERT_PASSENGER_SQL=  "INSERT INTO passenger(PassengerID,PassengerName,PassengerType,FlightId) " + "VALUES" + " (?, ?, ?,?);";

    
    
    public static final String SELECT_FLIGHT_SQL=  "select * from flight " ;
    public static final String SELECT_FLIGHT_SQL_ID=  "select * from flight WHERE flightid =?" ;
    
    public static final String SELECT_PASSENGER_FLIGHTID_SQL = "SELECT * FROM passenger where flightid = ?";

}
