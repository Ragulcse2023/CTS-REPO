package com.cognizant.fly.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.fly.bean.Passenger;

public interface PassengerDao {
	
	public void addAll(ArrayList<Passenger> list)
		     throws SQLException;
	    public void add(Passenger passenger)
	        throws SQLException;

	    public ArrayList<Passenger> viewByFlightNum(String FlightID)
	    		throws SQLException;
	  
}
