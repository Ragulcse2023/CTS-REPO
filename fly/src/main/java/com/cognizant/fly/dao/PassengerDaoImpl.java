package com.cognizant.fly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.cognizant.fly.bean.Passenger;
import com.cognizant.fly.constants.ApplicationConstantsUtil;
import com.cognizant.fly.util.DatabaseConnection;

public class PassengerDaoImpl implements PassengerDao {

	public void addAll(ArrayList<Passenger> list) throws SQLException {
	    Connection con = null;
	    PreparedStatement prepStmt = null;
	    try {
	        con = DatabaseConnection.getConnection();
	        con.setAutoCommit(false);
	        Iterator<Passenger> it = list.iterator();
	        while (it.hasNext()) {
	            Passenger pass = it.next();
	            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM passenger WHERE passengerId = ?");
	            checkStmt.setString(1, pass.getPassengerId());
	            ResultSet rs = checkStmt.executeQuery();
	            if (rs.next() && rs.getInt(1) > 0) {
	                // The Passenger already exists, handle it as needed
	                System.out.println("A Passenger with passengerId " + pass.getPassengerId() + " already exists.");
	            } else {
	                prepStmt = con.prepareStatement(ApplicationConstantsUtil.INSERT_PASSENGER_SQL);
	                prepStmt.setString(1, pass.getPassengerId());
	                prepStmt.setString(2, pass.getPassengerName());
	                prepStmt.setString(3, pass.getPassengerType());
	                prepStmt.setString(4, pass.getFlight().getFlightId());
	                prepStmt.execute();
	            }
	        }
	        con.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        if (con != null) {
	            try {
	                System.err.print("Transaction is being rolled back");
	                con.rollback();
	            } catch(SQLException excep) {
	                excep.printStackTrace();
	            }
	        }
	    } finally {
	        if (prepStmt != null) {
	            prepStmt.close();
	        }
	        if (con != null) {
	        }
	    }
	}


	public void add(Passenger passenger) throws SQLException {
	    Connection con = DatabaseConnection.getConnection();
	    con.setAutoCommit(false);
	    // Check if a Passenger with the same passengerId already exists
	    PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM passenger WHERE passengerId = ?");
	    checkStmt.setString(1, passenger.getPassengerId());
	    ResultSet rs = checkStmt.executeQuery();
	    if (rs.next() && rs.getInt(1) > 0) {
	        // The Passenger already exists, handle it as needed
	        System.out.println("A Passenger with passengerId " + passenger.getPassengerId() + " already exists.");
	    } else {
	        // The Passenger does not exist, insert it
	        PreparedStatement prepStmt = con.prepareStatement(ApplicationConstantsUtil.INSERT_PASSENGER_SQL);
	        prepStmt.setString(1, passenger.getPassengerId());
	        prepStmt.setString(2, passenger.getPassengerName());
	        prepStmt.setString(3, passenger.getPassengerType());
	        prepStmt.setString(4, passenger.getFlightId());
	        prepStmt.execute();
	    }

	    con.commit();
	}


	public ArrayList<Passenger> viewByFlightNum(String flightID) throws SQLException {
		ArrayList<Passenger> passenger = new ArrayList<Passenger>();
		String s = "SELECT * FROM passenger where flightid = ?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement prepStmt = con.prepareStatement(s);
		prepStmt.setString(1, flightID);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Passenger pass = new Passenger();
			pass.setPassengerId(rs.getString(1));
			pass.setPassengerName(rs.getString(2));
			pass.setPassengerType(rs.getString(3));

			passenger.add(pass);
			System.out.println(pass);
		}

		return passenger;
	}

}
