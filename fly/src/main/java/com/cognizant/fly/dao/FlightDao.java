package com.cognizant.fly.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.fly.bean.Flight;

public interface FlightDao {

	
		  public void addAll(ArrayList<Flight> list)
		     throws SQLException;
	    public int add(Flight fly)
	        throws SQLException;
	   	}
