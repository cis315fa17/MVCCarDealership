package cs315.mvccardealership;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krist
 */
public class ModelVehicle
{
    private String strType;
    private String strMake;
    private String strModel;
    private String strYear;
    private int intCustomerID;
    private int intVehicleID;
 
    
    //constructor that takes in all variables
    public ModelVehicle(String addType, String addMake, String addModel,
        String addYear, int addCustomerID, int addVehicleID)
    {
        strType = addType;
        strMake = addMake;
        strModel = addModel;
        strYear = addYear;
        intCustomerID = addCustomerID;
        intVehicleID = addVehicleID;
    }
     
    
    //setter methods for all variables customerID and vehicleID
    public void setType(String setType)
    {
        strType = setType;
    }
       
    public void setMake(String setMake)
    {
        strMake = setMake;
    }
    
    public void setModel(String setModel)
    {
        strModel = setModel;
    }
    
    public void setYear(String setYear)
    {
        strYear = setYear;
    }    
    
    
    //getter methods for all variables
    public String getType()
    {
        return strType; 
    }
    
    public String getMake()
    {
        return strMake;
    }
    
    public String getModel()
    {
        return strModel;
    }
    
    public String getYear()
    {
        return strYear;
    }
    
    public int getCustomerID()
    {
        return intCustomerID;  
    }
    
    public int getVehicleID()
    {
        return intVehicleID;
    }
}
