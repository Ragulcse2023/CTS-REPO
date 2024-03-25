package com.cognizant.fly.dao;

import com.cognizant.fly.constants.ApplicationConstantsUtil;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cognizant.fly.bean.Flight;
import com.cognizant.fly.bean.Passenger;
import com.cognizant.fly.util.DatabaseConnection;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FlightDaoImpl implements FlightDao {

	
//	public void addAll(ArrayList<Flight> list) throws SQLException {
//        PreparedStatement prepStmt = null;
//        Connection con;
//        ResultSet rs;
//        int last_inserted_id=0;
//        System.out.println("Indised add");
//        try {
//		    con = DatabaseConnection.getConnection();
//			con.setAutoCommit(false);
//			prepStmt = con.prepareStatement(ApplicationConstantsUtil.INSERT_FLIGHT_SQL);
//			Iterator<Flight> it = list.iterator();
//	        System.out.println("Indised add");
//	        System.out.println(it.hasNext());
//			while (it.hasNext()) {
//		        System.out.println("Inside add");
//				Flight fly = it.next();
//
//				prepStmt.setString(1, fly.getFlightId());
//				prepStmt.setDouble(2, fly.getAdultFare());
//				prepStmt.setDouble(3, fly.getChildFarePercentage());
//
//				prepStmt.execute();
//                rs = prepStmt.getGeneratedKeys();
//                if(rs.next())
//                {
//                     last_inserted_id = rs.getInt(1);
//                }
//                System.out.print(last_inserted_id);
//                fly.setId(last_inserted_id);
//			}
//			con.commit();
//
//		} catch (BatchUpdateException e) {
//			e.printStackTrace();
//		}
//       
//        finally {
//            if (prepStmt != null) { prepStmt.close(); }
//            //if (con != null) { con.close(); }
//        }
//
//	}
	@Override
	public void addAll(ArrayList<Flight> list) throws SQLException {
	    PreparedStatement prepStmt = null;
	    Connection con;
	    ResultSet rs;
	    int last_inserted_id=0;
	    try {
	        con = DatabaseConnection.getConnection();
	        con.setAutoCommit(false);
	        prepStmt = con.prepareStatement(ApplicationConstantsUtil.INSERT_FLIGHT_SQL, Statement.RETURN_GENERATED_KEYS);
	        Iterator<Flight> it = list.iterator();
	        while (it.hasNext()) {
	            Flight fly = it.next();

	            // Check if the flightId already exists in the database
	            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM Flight WHERE flightId = ?");
	            checkStmt.setString(1, fly.getFlightId());
	            ResultSet checkRs = checkStmt.executeQuery();
	            if (checkRs.next() && checkRs.getInt(1) > 0) {
	                // The flightId already exists, skip this flight
	                continue;
	            }

	            prepStmt.setString(1, fly.getFlightId());
	            prepStmt.setDouble(2, fly.getAdultFare());
	            prepStmt.setDouble(3, fly.getChildFarePercentage());

	            prepStmt.execute();
	            rs = prepStmt.getGeneratedKeys();
	            if(rs.next())
	            {
	                last_inserted_id = rs.getInt(1);
	            }
	            System.out.print(last_inserted_id);
	            fly.setId(last_inserted_id);
	        }
	        con.commit();

	    } catch (BatchUpdateException e) {
	        e.printStackTrace();
	    }

	    finally {
	        if (prepStmt != null) { prepStmt.close(); }
	        //if (con != null) { con.close(); }
	    }

	}

	@Override
	public int add(Flight fly) throws SQLException {
		// TODO Auto-generated method stub
		int updatedRec=0;
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement prepStmt=null;
		try{
        prepStmt = con.prepareStatement(ApplicationConstantsUtil.INSERT_FLIGHT_SQL);
        prepStmt.setString(2, fly.getFlightId());
		prepStmt.setDouble(3, fly.getChildFarePercentage());
		prepStmt.setDouble(4, fly.getAdultFare());
        updatedRec= prepStmt.executeUpdate();
        }catch (SQLException exp)
        {
            exp.printStackTrace();
        }

            finally
            {
                if (prepStmt != null) { prepStmt.close(); }
                if (con != null) { con.close(); }
            }

       return updatedRec;
    }

	public ArrayList<Flight> view() throws SQLException {
		ArrayList flight = new ArrayList();
        PreparedStatement prepStmt=null;
		Connection con = DatabaseConnection.getConnection();
		try{
        con.setAutoCommit(false);
	    prepStmt = con.prepareStatement(ApplicationConstantsUtil.SELECT_FLIGHT_SQL);

		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Flight fly = new Flight();
			fly.setId(rs.getLong("Flight_ID"));
            fly.setFlightId(rs.getString("Flight_NO"));
			fly.setAdultFare(rs.getDouble("Adult_FARE"));
			fly.setChildFarePercentage(rs.getDouble("Child_FARE"));
			flight.add(fly);
		}


    }catch(Exception exp)
    {
        exp.printStackTrace();
    }
        finally
        {
            if (prepStmt != null) { prepStmt.close(); }
            if (con != null) { con.close(); }
        }
        return flight;
}  }