package cs315.mvccardealership;

import cs315.mvccardealership.CarDealershipModel;
import cs315.mvccardealership.View;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author atmanning
 */
public class CarDealershipController {

    View myView;
    CarDealershipModel myModel;
    CarDealershipController myController;

    // constructor
    CarDealershipController(View v, CarDealershipModel m) {

        myView = v;

        myView.setNewAccountActionListener(new actionNewAccount());

        myModel = m;

    }

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