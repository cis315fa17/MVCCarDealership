/*
 * file: CS315MVCCarDealership.java
 * 
 *  (c)2017 by Arthur Manning atmanning@dbq.edu
 *    attempting to update github with changes...
 *    modified by atmanning on a different pc
 *      to update to remote project:
 *      commit the changes /team\..commit...
 *        /team\..remote->push
 *   pull is the same as fetch and then a merge
 *   success at clone process 11/17 by atm - arthurmanning 11/28 +1
 */

package cs315.mvccardealership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author amanning
 */
public class Cs315MVCCarDealership implements java.awt.event.ActionListener{
CarDealershipModel myModel;
View myView;
 public void actionPerformed(ActionEvent e){
        v.registerNewAccountButtonAction((ActionListener) e);
        System.out.println(e.toString());
  
    public static void main(String[] args) {
//make a model classs
        CarDealershipModel myModel = new CarDealershipModel();

//make a view class
//feed to the controller class
        View myView = new View();

//set the window to visible
        myView.setVisible(true);
    }
}

/**
 * Just a class to help keep the Controller cleaner;
 *
 * any major functions or repeatable things should be written into this class
 *
 */
class ControllerFunctions {

//Service
//One time a day on the first time load the service information.
    /**
     * getDateDifference V2.0 (getCalendar)
     *
     *
     * this function given the information in int's (year, month, day) will
     * return the number of days from the current date
     *
     *
     * NOTE: will return 0 if the same date and negative if the given date is in
     * the future
     *
     * Potential Logic Errors: If date exceeds month or month exceeds limit due
     * to logic used, if the day or month is out of line, it will simply
     * calculate from the given year, cycle through given x months then through
     * x days
     *
     */
    public int getDateDifference(int YEAR, int MONTH, int DAY) {
        //Saves current time
        Calendar calTemp = Calendar.getInstance();
        //Saves Todays time stamp to be used for calculation later
        Date ToDay = calTemp.getTime();
        //input the values into the calendar 'calTemp' which is subsequently turned into the XDay class
        calTemp.set(Calendar.DAY_OF_MONTH, DAY);
        calTemp.set(Calendar.MONTH, MONTH - 1);
        calTemp.set(Calendar.YEAR, YEAR);
        //X Day - given date translation to date from calendar class
        Date XDay = calTemp.getTime();
        //divide into a way to long number
        long diff = (ToDay.getTime() - XDay.getTime());
        //milliseconds to seconds to minutes to hours
        //type cast it to int, should be fine conversion after division due to the slicing that occurs at each division in java
        return (int) ((((diff / 1000) / 60) / 60) / 24);
    }

}
class actionNewAccount{

 public void actionPreformed(java.awt.event.ActionEvent evt){
     ArrayList<String> currentCustomer = v.getNewCustomerInfo();
     
     
     
     //String addFirstName, String addLastName,
            //String addAddressNumber, String addStreetName, String addCity,
            //String addState, String addZip, String addPhoneNumber)
}
}
