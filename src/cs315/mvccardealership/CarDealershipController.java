package cs315.mvccardealership;

import cs315.mvccardealership.CarDealershipModel;
import cs315.mvccardealership.View;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/*
 *In order to avoid problems with accessing dynamic variables from static main, 
 * this controller class can now be used to control the view events and interact with the mode;
 */
public class CarDealershipController {

    View myView;
    CarDealershipModel myModel;
    CarDealershipController myController;

    // constructor - called from project main()
    CarDealershipController(View v, CarDealershipModel m) {

        myView = v;

        // because of the way Netbeans attaches events to buttons, this action happens before
        // the 'normal' button action
        myView.registerNewAccountButtonAction(new actionNewAccount());

        myModel = m;

    }

    
    // this code is set to run when the [New Account] button is pressed
    //
    class actionNewAccount implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("getting new account info from View...");

            ArrayList<String> currentCustomer = myView.getNewCustomerInfo();

            System.out.println("new account info: " + currentCustomer.toString());

            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
