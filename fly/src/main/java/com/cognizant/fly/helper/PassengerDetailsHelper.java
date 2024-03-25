package com.cognizant.fly.helper;

import java.util.ArrayList;

import com.cognizant.fly.bean.AdultPassenger;
import com.cognizant.fly.bean.ChildPassenger;
import com.cognizant.fly.bean.Passenger;
import com.cognizant.fly.constants.ApplicationConstantsUtil;
import com.cognizant.fly.exception.ApplicationException;
import com.cognizant.fly.exception.InvalidPassengerException;
import com.cognizant.fly.util.ApplicationUtil;

public class PassengerDetailsHelper {

    private static ArrayList<Passenger> passesngerList = new ArrayList<Passenger>();

    /**
     * @param inputFeed
     * @return ArrayList<Passenger>
     * @throws com.cognizant.fly.exception.ApplicationException
     */
    public static ArrayList<Passenger> getAllPassengers(String inputFeed)
            throws com.cognizant.fly.exception.ApplicationException {

        return buildPassengers(ApplicationUtil.readFile(inputFeed));
    }

    
    

	public static ArrayList<Passenger> getPassesngerList() {
		return passesngerList;
	}




	public static void setPassesngerList(ArrayList<Passenger> passesngerList) {
		PassengerDetailsHelper.passesngerList = passesngerList;
	}




	/**
     * @param records
     * @return ArrayList<Passenger>
     * @throws ApplicationException
     */
    private static ArrayList<Passenger> buildPassengers(ArrayList<String> records) throws ApplicationException {
        Passenger passenger;
        if (records == null || (records != null && records.size() == 0)) {
            throw new ApplicationException("Passenger Feed not present");
        }
        for (int i = 0; i < records.size()-1; i++) {
            try {
                String[] passengerElements = records.get(i).split(ApplicationConstantsUtil.NEW_FEED_DELIMITER);

                if (passengerElements[1].equalsIgnoreCase("A"))
                    passenger = new AdultPassenger(passengerElements);
                else
                    passenger = new ChildPassenger(passengerElements);
                passesngerList.add(passenger);

            } catch (InvalidPassengerException e) {
                System.err.println(e.getMessage());
                continue;
            }

        }
        return passesngerList;
    }
}
