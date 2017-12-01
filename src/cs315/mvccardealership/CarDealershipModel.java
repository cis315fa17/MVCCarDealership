package cs315.mvccardealership;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author krist
	@author KatieHansen
 */
public class CarDealershipModel
{
    int lastServiceID;
    int lastCustomerID;
    int lastVehicleID;
    int lastServiceListID;

    ArrayList<ModelCustomer> Customers = new ArrayList<ModelCustomer>();
    ArrayList<ModelVehicle> Vehicles = new ArrayList<ModelVehicle>();
    ArrayList<ModelServiceSchedule> ServiceSchedules = new  ArrayList<ModelServiceSchedule>();
    ArrayList<ModelServiceList> ServiceLists = new ArrayList<ModelServiceList>();

    public void addCustomer(String addFirstName, String addLastName,
        String addAddressNumber, String addStreetName, String addCity,
        String addState, String addZip, String addPhoneNumber)
    {
        lastCustomerID++;
        Customers.add(new ModelCustomer(addFirstName, addLastName,
                addAddressNumber, addStreetName, addCity, addState, addZip,
                addPhoneNumber, lastCustomerID));
    }

    public void addVehicle(String addType, String addMake, String addModel,
    String addYear, int addCustomerID)
    {
        lastVehicleID++;
        Vehicles.add(new ModelVehicle(addType, addMake, addModel,
                addYear, addCustomerID, lastVehicleID));
    }

    public void addModelServiceSchedule(double addMileage, String addServicePerformed,
        Date addNextServiceDue, Date addDateOfService,
        int addVehicleID, int addServiceListID)
    {
        lastServiceID++;
        ServiceSchedules.add(new ModelServiceSchedule(
                addMileage, addServicePerformed, addNextServiceDue,
                addDateOfService, addVehicleID, lastServiceID, addServiceListID));
    }
    
    public void addModelServiceList(String addServiceName, String addDescription,
            double addServiceMileage)
    {
        lastServiceListID++;
        ServiceLists.add(new ModelServiceList(addServiceName, addDescription,
            addServiceMileage, lastServiceListID));
    }
    public ModelCustomer searchForCustomer(int customerID)
    {
        ModelCustomer returnCustomer = null;

        for(ModelCustomer c : Customers)
        {
            int currentCustomerID = c.getCustomerID();
            if (currentCustomerID == customerID)
            {
                returnCustomer = c;
                return c;
            }
        }
    
        if(returnCustomer == null)
        {
            System.out.println("Customer with that customer ID does not exist");
        }
    
        return returnCustomer;
    }
    
    public ModelVehicle searchForVehicle(int vehicleID)
    {
        ModelVehicle returnVehicle = null;

        for(ModelVehicle v : Vehicles)
        {
            int currentVehicleID = v.getVehicleID();
            if (currentVehicleID == vehicleID)
            {
                returnVehicle = v;
                return v;
            }
        }
    
        if(returnVehicle == null)
        {
            System.out.println("Vehicle with that vehicle ID does not exist");
        }
    
        return returnVehicle;
    
    }
    
    public ModelCustomer searchForCustomerByID(int customerID)
    {
        ModelCustomer returnCustomer = null;

        for(ModelCustomer c : Customers)
        {
            int currentCustomerID = c.getCustomerID();
            if (currentCustomerID == customerID)
            {
                returnCustomer = c;
                return c;
            }
        }

        if(returnCustomer == null)
        {
            System.out.println("Customer with that customer ID does not exist");
        }

        return returnCustomer;

    }
    
    public ModelVehicle searchForVehicleByID(int vehicleID)
    {
        ModelVehicle returnVehicle = null;

        for(ModelVehicle v : Vehicles)
        {
            int currentVehicleID = v.getVehicleID();
            if (currentVehicleID == vehicleID)
            {
                returnVehicle = v;
                return v;
            }
        }

        if(returnVehicle == null)
        {
            System.out.println("Vehicle with that vehicle ID does not exist");
        }

        return returnVehicle;

    }
    
    public ModelCustomer searchForCustomerByName(String firstName, String lastName)
    {
        ModelCustomer returnCustomer = null;
        for(ModelCustomer c : Customers){
            String currentCustomerFN = c.getFirstName();
            String currentCustomerLN = c.getLastName();
            if(currentCustomerFN == firstName && currentCustomerLN == lastName)
            {
                returnCustomer = c;  
                return returnCustomer;
            }
        }
        if(returnCustomer == null)
        {
            System.out.println("Customer with this name does not exist");
        }
        return returnCustomer;
    }

    public ArrayList<ModelVehicle> getAllVehiclesOwned(String firstName, String lastName)
    {
        ArrayList<ModelVehicle> returnArray = null;
        ModelCustomer customer = null;
        int customerID =0;

        for(ModelCustomer c : Customers)
        {
            String currentCustomerFN = c.getFirstName();
            String currentCustomerLN = c.getLastName();
            if(currentCustomerFN == firstName && currentCustomerLN == lastName)
            {
                customer = c; 
                customerID = c.getCustomerID();
                break;
            }

            for(ModelVehicle v : Vehicles)
            {
                int currentCustomerID = v.getCustomerID();
                if(customerID == currentCustomerID)
                {
                    returnArray.add(v);
                }
            }
        }
        return returnArray;
    }
    
    public ArrayList<ModelVehicle> getAllVehiclesOwnedByID(int customerIDNum)
    {
        ArrayList<ModelVehicle> returnArray = null;
        int customerID =0;
        for(ModelCustomer c : Customers)
        {
            for(ModelVehicle v : Vehicles)
            {
                int currentCustomerID = v.getCustomerID();
                if(customerIDNum == currentCustomerID)
                {
                    returnArray.add(v);
                }
            }
        }
        return returnArray;
    }
    
    public ArrayList<ModelServiceSchedule> getAllOfServicePerformed(String service) {
        ArrayList<ModelServiceSchedule> returnArray = null;

        String servicePerform = " ";
        for (ModelServiceSchedule s : ServiceSchedules) {
            servicePerform = s.getServicePerformed();
            if (servicePerform == service) {
                returnArray.add(s);
            }

        }
        if (returnArray == null) {
            System.out.println("No services of that type were performed");
        }
        return returnArray;
    }

    
    public void LoadData() throws IOException
    {
        String strInput = "";
        int intCurrentID = 0;
        lastCustomerID = 0;
        FileReader inputFile = new FileReader("CustomerFile.txt");
        BufferedReader customerFile = new BufferedReader(inputFile);
        while ((strInput = customerFile.readLine()) != null)
        {
            String[] strArrayInput = strInput.split(",");
            
            intCurrentID = Integer.parseInt(strArrayInput[8]);
            if (intCurrentID > lastCustomerID)
            {
                lastCustomerID = intCurrentID;
            
            new ModelCustomer(strArrayInput[0], strArrayInput[1], strArrayInput[2],
                    strArrayInput[3], strArrayInput[4], strArrayInput[5],
                    strArrayInput[6], strArrayInput[7], intCurrentID);
            }
        }
        lastCustomerID = intCurrentID;
        
        strInput = "";
        intCurrentID = 0;
        lastVehicleID = 0;
        FileReader inputVehicleFile = new FileReader("VehicleFile.txt");
        BufferedReader vehicleFile = new BufferedReader(inputVehicleFile);
        while ((strInput = vehicleFile.readLine()) != null)
        {
            String[] strArrayInput = strInput.split(",");
            
            intCurrentID = Integer.parseInt(strArrayInput[5]);
            if (intCurrentID > lastVehicleID)
            {
                lastVehicleID = intCurrentID;
            
            new ModelVehicle(strArrayInput[0],
                    strArrayInput[1],
                    strArrayInput[2],
                    strArrayInput[3],
                    Integer.parseInt(strArrayInput[4]),
                    intCurrentID);
            }
        }       
        lastVehicleID = intCurrentID;

        vehicleFile.close();
        
        strInput = "";
        intCurrentID = 0;
        lastServiceID = 0;
        FileReader inputServiceScheduleFile = new FileReader("ServiceScheduleFile.txt");
        BufferedReader serviceScheduleFile = new BufferedReader(inputServiceScheduleFile);
        while ((strInput = serviceScheduleFile.readLine()) != null)
        {
            String[] strArrayInput = strInput.split(",");
            
            intCurrentID = Integer.parseInt(strArrayInput[7]);
            if (intCurrentID > lastServiceID)
            {
                lastServiceID = intCurrentID;
                
                String startServiceDateString = strArrayInput[2];
                DateFormat serviceDateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
                Date serviceDate;
                try
                {
                    serviceDate = serviceDateFormat.parse(startServiceDateString);
                }
                catch (Exception e)
                {
                    serviceDate = null;
                }
                
                String nextServiceDateString = strArrayInput[2];
                DateFormat nextServiceDateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
                Date nextServiceDate;
                try
                {
                    nextServiceDate = nextServiceDateFormat.parse(nextServiceDateString);
                }
                catch (Exception e)
                {
                    nextServiceDate = null;
                }
                
                new ModelServiceSchedule(
                        Double.parseDouble(strArrayInput[0]),
                        strArrayInput[1],
                        serviceDate,
                        nextServiceDate,
                        intCurrentID,
                        Integer.parseInt(strArrayInput[5]),
                        Integer.parseInt(strArrayInput[6]));
            }
        }       
        lastServiceID = intCurrentID;        
        
        strInput = "";
        intCurrentID = 0;
        lastServiceListID = 0;
        FileReader inputServiceListFile = new FileReader("ServiceScheduleFile.txt");
        BufferedReader serviceListFile = new BufferedReader(inputServiceListFile);
        while ((strInput = serviceListFile.readLine()) != null)
        {
            String[] strArrayInput = strInput.split(",");
            
            intCurrentID = Integer.parseInt(strArrayInput[4]);
            if (intCurrentID > lastServiceListID)
            {
                lastServiceListID = intCurrentID;
                
                new ModelServiceList(
                        strArrayInput[0],
                        strArrayInput[1],
                        Double.parseDouble(strArrayInput[2]),
                        intCurrentID);
            }
        }       
        lastServiceListID = intCurrentID;
    }
    
    public void SaveData() throws IOException
    {
        PrintWriter customerFile = new PrintWriter("CustomerFile.txt");
        for(ModelCustomer customer : Customers)
        {
            String strFirstName = customer.getFirstName();
            String strLastName = customer.getLastName();
            String strAddressNumber = customer.getAddressNum();
            String strStreetName = customer.getStreet();
            String strCity = customer.getstrCity();
            String strState = customer.getstrState();
            String strZip = customer.getstrZip();
            String strPhoneNumber = customer.getstrPhoneNumber();
            String strCustomerID = Integer.toString(customer.getCustomerID());
            
            String strOutput = strFirstName + "," + 
                    strLastName + "," + 
                    strAddressNumber + "," + 
                    strStreetName + "," + 
                    strCity + "," + 
                    strState + "," + 
                    strZip + "," + 
                    strPhoneNumber + "," + 
                    strCustomerID;
            
            customerFile.println(strOutput);
        }
        customerFile.close();
        
        PrintWriter vehicleFile = new PrintWriter("VehicleFile.txt");
        for(ModelVehicle vehicle : Vehicles)
        {
            String strType = vehicle.getType();
            String strMake = vehicle.getMake();
            String strModel = vehicle.getModel();
            String strYear = vehicle.getYear();
            String intCustomerID = Integer.toString(vehicle.getCustomerID());
            String intVehicleID = Integer.toString(vehicle.getVehicleID());
            
            String strOutput = strType + "," + 
                    strMake + "," + 
                    strModel + "," + 
                    strYear + "," + 
                    intCustomerID + "," + 
                    intVehicleID;
            
            vehicleFile.println(strOutput);
        }
        vehicleFile.close();
        
        PrintWriter serviceListFile = new PrintWriter("ServiceListFile.txt");
        for(ModelServiceList serviceList : ServiceLists)
        {
            String strServiceName = serviceList.getServiceName();
            String strDescription = serviceList.getDescription();
            String strServiceMileage = Double.toString(serviceList.getServiceMileage());
            String strServiceTypeID = Double.toString(serviceList.getServiceTypeID());
            
            String strOutput = strServiceName + "," + 
                    strDescription + "," + 
                    strServiceMileage + "," + 
                    strServiceTypeID;
            
            serviceListFile.println(strOutput);
        }
        serviceListFile.close();
        
        PrintWriter serviceScheduleFile = new PrintWriter("ServiceScheduleFile.txt");
        for(ModelServiceSchedule serviceSchedule : ServiceSchedules)
        {
            String strMileage = Double.toString(serviceSchedule.getMileage());
            String strServicePerformed = serviceSchedule.getServicePerformed();
            SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            String strDateOfService = formatDate.format(serviceSchedule.getDateOfService());
            String strDateNextServiceDue = formatDate.format(serviceSchedule.getNextServiceDue());
            String strServiceID = Integer.toString(serviceSchedule.getServiceID());
            String strVehicleID = Integer.toString(serviceSchedule.getVehicleID());
            String strServiceListID = Integer.toString(serviceSchedule.getServiceListID());
            
            String strOutput = strMileage + "," + 
                    strServicePerformed + "," + 
                    strDateOfService + "," + 
                    strDateNextServiceDue + "," + 
                    strServiceID + "," + 
                    strVehicleID + "," + 
                    strServiceListID;
            
            serviceScheduleFile.println(strOutput);
        }
        serviceScheduleFile.close();
    }

}