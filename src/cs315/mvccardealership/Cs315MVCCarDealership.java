/*
 * file: CS315MVCCarDealership.java
 * 
 *  (c)2017 by Arthur Manning atmanning@dbq.edu
 *    attempting to update github with changes...
 *    modified by atmanning on a different pc
 *      to update to remote project:
 *      commit the changes /team\..commit...
 *        /team\..git-remote-push
 * 
 */

package cs315.mvccardealership;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author amanning
 */
public class Cs315MVCCarDealership {

    /*
 * Controller Group Class
 * Members: Liam, Carter, Evan
 * Creation Date: 10-25-2017
     */
//package mvc.car.service;
    /**
     *
     * Revisions and Additions:
     *
     * Please specify name and put the date & time above your changes Check the
     * code back in when you are done or might take a break
     *
     */
//  Liam's name: public class MVCCarMain {
    /**
     * -Start initialization by checking for existence of all needed class, ex:
     * use try to find the view and data groups classes. <- Note should abort
     * all process if the method call the view groups class to open the first
     * menu page -begin loop <- NOTE this should only loop as long as the view
     * window is open wait for triggers of buttons and refer to various methods
     * to redraw screen to fit needs wait for data triggers: for, people, cars,
     * and general service info Queries ReEntry New Deletes use appropriate
     * functions to check every 6-12 hours for service calls <- currently
     * supposed to simply be a page. ask data group for a savable spot to record
     * the cars that need servicing appropriately close all functions when
     * window is closed <- note should include use case of improper closing: ex.
     * halfway through making a new customer
     */
    /*Note that actionlisteners will simply interpret.
    *all looping functions and calls should occur here
     */
    public static void main(String[] args) {
//make a model class
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

    //function to determine given a date whether any vehicle needs to be serviced
    //function to determine given a date the number of days since.
    //Communication with the model given user input
    //Communication and data given user input
    //Function to communicate which page should be displayed
    //Function to tell view to display a new window as an error screen with custom text error message
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

/**
 * View group associate to find out how to interface with the view group as far
 * as buttons and navigating going.
 *
 * Logic Writer
 *
 * Navigating / interfacing with view group: carter Handling logic and
 * calculations: evan Talking to model group:Liam
 */
