package cs315.mvccardealership;

/**
 *
 * @author krist
 */
public class ModelServiceList {

    private String strServiceName;
    private String strDescription;
    private double dblServiceMileage;
    private int intServiceTypeID;

    ModelServiceList(String addServiceName, String addDescription,
            double addServiceMileage, int addServiceTypeID) {
        strServiceName = addServiceName;
        strDescription = addDescription;
        dblServiceMileage = addServiceMileage;
        intServiceTypeID = addServiceTypeID;
    }

    private void setServiceName(String setServiceName) {
        strServiceName = setServiceName;
    }

    private void setDescription(String setDescription) {
        strDescription = setDescription;
    }

    private void setServiceMileage(double setServiceMileage) {
        dblServiceMileage = setServiceMileage;
    }

    private int getServiceTypeID() {
        return intServiceTypeID;
    }

    private String getServiceName() {
        return strServiceName;
    }

    private String getDescription() {
        return strDescription;
    }

    private double getServiceMileage() {
        return dblServiceMileage;
    }
}
