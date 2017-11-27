package cs315.mvccardealership;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
/*
@author kristjahnSaliga
@author katieHansen

reviewed by atm 11/27 -- needs comments 
  add links to your google docs if they are helpful
*/
public class CarDealershipModel {

    int lastServiceID;
    int lastCustomerID;
    int lastVehicleID;
    int lastServiceListID;

    ArrayList<ModelCustomer> Customers = new ArrayList<ModelCustomer>();
    ArrayList<ModelVehicle> Vehicles = new ArrayList<ModelVehicle>();
    ArrayList<ModelServiceSchedule> ServiceSchedules = new ArrayList<ModelServiceSchedule>();
    ArrayList<ModelServiceList> ServiceLists = new ArrayList<ModelServiceList>();

    public void addCustomer(String addFirstName, String addLastName,
            String addAddressNumber, String addStreetName, String addCity,
            String addState, String addZip, String addPhoneNumber) {
        lastCustomerID++;
        Customers.add(new ModelCustomer(addFirstName, addLastName,
                addAddressNumber, addStreetName, addCity, addState, addZip,
                addPhoneNumber, lastCustomerID));
    }

    public void addVehicle(String addType, String addMake, String addModel,
            String addYear, int addCustomerID) {
        lastVehicleID++;
        Vehicles.add(new ModelVehicle(addType, addMake, addModel,
                addYear, addCustomerID, lastVehicleID));
    }

    public void addModelServiceSchedule(double addMileage, String addServicePerformed,
            Date addNextServiceDue, Date addDateOfService,
            int addVehicleID, int addServiceListID) {
        lastServiceID++;
        ServiceSchedules.add(new ModelServiceSchedule(
                addMileage, addServicePerformed, addNextServiceDue,
                addDateOfService, addVehicleID, lastServiceID, addServiceListID));
    }

    public void addModelServiceList(String addServiceName, String addDescription,
            double addServiceMileage) {
        lastServiceListID++;
        ServiceLists.add(new ModelServiceList(addServiceName, addDescription,
                addServiceMileage, lastServiceListID));
    }

    public ModelCustomer searchForCustomer(int customerID) {
        ModelCustomer returnCustomer = null;

        for (ModelCustomer c : Customers) {
            int currentCustomerID = c.getCustomerID();
            if (currentCustomerID == customerID) {
                returnCustomer = c;
            }
            return c;
        }

        if (returnCustomer == null) {
            System.out.println("Customer with that customer ID does not exist");
        }

        return returnCustomer;

    }

    public ModelVehicle searchForVehicle(int vehicleID) {
        ModelVehicle returnVehicle = null;

        for (ModelVehicle v : Vehicles) {
            int currentVehicleID = v.getVehicleID();
            if (currentVehicleID == vehicleID) {
                returnVehicle = v;
            }
            return v;
        }

        if (returnVehicle == null) {
            System.out.println("Vehicle with that vehicle ID does not exist");
        }

        return returnVehicle;

    }

    public ModelCustomer searchForCustomerByaphone(String customerPhone) {
        ModelCustomer returnCustomer = null;

        for (ModelCustomer c : Customers) {
            String currentCustomerPhone = c.getstrPhoneNumber();
            if (currentCustomerPhone == customerPhone) {
                returnCustomer = c;
            }
            return c;
        }

        if (returnCustomer == null) {
            System.out.println("Customer with that phone number does not exist");
        }

        return returnCustomer;

    }

    public ModelVehicle searchForVehicleByID(int vehicleID) {
        ModelVehicle returnVehicle = null;

        for (ModelVehicle v : Vehicles) {
            int currentVehicleID = v.getVehicleID();
            if (currentVehicleID == vehicleID) {
                returnVehicle = v;
            }
            return v;
        }

        if (returnVehicle == null) {
            System.out.println("Vehicle with that vehicle ID does not exist");
        }

        return returnVehicle;

    }

    public ModelCustomer searchForCustomerByName(String firstName, String lastName) {
        ModelCustomer returnCustomer = null;
        for (ModelCustomer c : Customers) {
            String currentCustomerFN = c.getFirstName();
            String currentCustomerLN = c.getLastName();
            if (currentCustomerFN == firstName && currentCustomerLN == lastName) {
                returnCustomer = c;
                return returnCustomer;
            }
        }
        if (returnCustomer == null) {
            System.out.println("Customer with this name does not exist");
        }
        return returnCustomer;

    }

    public ArrayList<ModelVehicle> getAllVehiclesOwned(String firstName, String lastName) {
        ArrayList<ModelVehicle> returnArray = null;
        ModelCustomer customer = null;
        int customerID = 0;

        for (ModelCustomer c : Customers) {
            String currentCustomerFN = c.getFirstName();
            String currentCustomerLN = c.getLastName();
            if (currentCustomerFN == firstName && currentCustomerLN == lastName) {
                customer = c;
                customerID = c.getCustomerID();
                break;
            }

            for (ModelVehicle v : Vehicles) {
                int currentCustomerID = v.getCustomerID();
                if (customerID == currentCustomerID) {
                    returnArray.add(v);

                }
            }
        }
        return returnArray;

    }

    public ArrayList<ModelVehicle> getAllVehiclesOwnedByID(int customerIDNum) {
        ArrayList<ModelVehicle> returnArray = null;

        int customerID = 0;

        for (ModelCustomer c : Customers) {

            for (ModelVehicle v : Vehicles) {
                int currentCustomerID = v.getCustomerID();
                if (customerIDNum == currentCustomerID) {
                    returnArray.add(v);

                }
            }
        }
        return returnArray;

    }

}
