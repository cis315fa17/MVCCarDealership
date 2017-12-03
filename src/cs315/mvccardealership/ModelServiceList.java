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
public class ModelServiceList
{
    private String strServiceName;
    private String strDescription;
    private double dblServiceMileage;
    private int intServiceTypeID;
    
    
    //constructor that takes in all variables
    ModelServiceList(String addServiceName, String addDescription,
            double addServiceMileage, int addServiceTypeID)
    {
        strServiceName = addServiceName;
        strDescription = addDescription;
        dblServiceMileage = addServiceMileage;
        intServiceTypeID = addServiceTypeID;
    }
    
    
    //setter methods for all variables except serviceTypeID
    public void setServiceName(String setServiceName)
    {
        strServiceName = setServiceName;
    }
    
    public void setDescription(String setDescription)
    {
        strDescription = setDescription;
    }
        
    public void setServiceMileage(double setServiceMileage)
    {
        dblServiceMileage = setServiceMileage;
    }
    
    
    //getter methods for all variables
    public int getServiceTypeID()
    {
        return intServiceTypeID;
    }
    
    public String getServiceName()
    {
        return strServiceName;
    }
    
    public String getDescription()
    {
        return strDescription;
    }
    
    public double getServiceMileage()
    {
        return dblServiceMileage;
    }
}
