package com.cognizant.fly.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.cognizant.fly.constants.ApplicationConstantsUtil;

public class ApplicationUtil {

    /**
     * //@param fileName
     * @return ArrayList<String>
     */
    public static ArrayList<String> readFile(String inputFeed) {
    	
    	String fileName= inputFeed;
        ArrayList<String> lines = new ArrayList<String>();
        String line = null;

        try {
            if (fileName != null) {
                BufferedReader in = new BufferedReader(new FileReader(fileName));
                while ((line = in.readLine()) != null)
                    lines.add(line);
                in.close();
            }

        } catch (FileNotFoundException e) {
            return null;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return lines;
    }

    /**
     * @param passengerId
     * @return Boolean
     */
    public static Boolean isValidPassengerId(String passengerId) {
        Boolean isValid = false;
        if ((passengerId != null)
                && (passengerId.startsWith(ApplicationConstantsUtil.PASSENGERID_PREFIX))) {
            isValid = true;
        }
        return isValid;
    }

}
