package com.cognizant.fly.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.cognizant.fly.bean.Flight;
import com.cognizant.fly.bean.Passenger;
import com.cognizant.fly.dao.FlightDaoImpl;
import com.cognizant.fly.dao.PassengerDaoImpl;
import com.cognizant.fly.exception.ApplicationException;
import com.cognizant.fly.helper.FlightDetailsHelper;
import com.cognizant.fly.helper.PassengerDetailsHelper;

public class Main {

    /**
     * @param args
     */
    public static void main(String args[]) {
        do{
         System.out.println("Enter Choice..... \n 1 To read data from csv file \n   2. To see existing data \n 3.Exit");
       
         try {
        	 int ch;
          Scanner sc = new Scanner(System.in);
            ch=  sc.nextInt();
        	
        	
            PassengerDaoImpl passengerDao = new PassengerDaoImpl();


            switch (ch) {
            case 1:
               RateCalculator.processAndDisplayPassengerFares();
               Collection<Flight> fly = FlightDetailsHelper.getFlighDetails().values();
                ArrayList<Flight> flight = new ArrayList<>(fly);
                FlightDaoImpl flightDao = new FlightDaoImpl();
                try{
                    flightDao.addAll(flight);
                }catch (Exception exp)
                {
                    exp.printStackTrace();
                }
                     System.out.println("Display Passenger details");
                 ArrayList<Passenger> passenger = PassengerDetailsHelper.getPassesngerList();
                 passengerDao.addAll(passenger); 
             break;
             
            case 2:
            	 System.out.println("Enter the Flight Number to fetch passenger details:");
                 String searchBy=sc.next();

                System.out.println("Fetch passenger details by :"+searchBy);

                
                ArrayList<Passenger> passengerList = passengerDao.viewByFlightNum(searchBy);
                if(passengerList.size()==0) {
                	System.out.println(passengerDao.viewByFlightNum(searchBy));
                	System.out.println("no records found......");
                	break;
                }
                else
                {
                	for ( Passenger  pass : passengerList ) 
                    System.out.println( pass.getPassengerId() + " " + pass.getPassengerName() + " " + pass.getPassengerType());
            	break;
                }
                case 3:System.exit(0);
                default:System.out.println("\n Wrong Choice \n");
            }
                
        } catch (ApplicationException e) {
           System.err.println(e.getMessage());
        }
        catch(SQLException e)
        {
        	System.err.println(e.getMessage());
        }
    }while(true);

}
}