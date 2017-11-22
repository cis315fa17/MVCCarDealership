package cs315.mvccardealership;

/*
 *
 * @author krist
 */
public class ModelCustomer {

    private String strFirstName;
    private String strLastName;
    private String strAddressNumber;
    private String strStreetName;
    private String strCity;
    private String strState;
    private String strZip;
    private String strPhoneNumber;
    private int intCustomerID;

    ModelCustomer(String addFirstName, String addLastName,
            String addAddressNumber, String addStreetName, String addCity,
            String addState, String addZip, String addPhoneNumber, int addCustomerID) {
        strFirstName = addFirstName;
        strLastName = addLastName;
        strAddressNumber = addAddressNumber;
        strStreetName = addStreetName;
        strCity = addCity;
        strState = addState;
        strZip = addZip;
        strPhoneNumber = addPhoneNumber;
    }

    public void setFirstName(String setFirstName) {
        strFirstName = setFirstName;
    }

    public void setLastName(String setLastName) {
        strLastName = setLastName;
    }

    public void setAddressNumber(String setAddressNumber) {
        strAddressNumber = setAddressNumber;
    }

    public void setStreetName(String setStreetName) {
        strStreetName = setStreetName;
    }

    public void setCity(String setCity) {
        strCity = setCity;
    }

    public void setState(String setState) {
        strState = setState;
    }

    public void setZip(String setZip) {
        strZip = setZip;
    }

    public void setPhoneNumber(String setPhoneNumber) {
        strPhoneNumber = setPhoneNumber;
    }

    public String getFirstName() {
        return strFirstName;
    }

    public String getLastName() {
        return strLastName;
    }

    public String getAddressNum() {
        return strAddressNumber;
    }

    public String getStreet() {
        return strStreetName;
    }

    public String getstrCity() {
        return strCity;
    }

    public String getstrState() {
        return strState;
    }

    public String getstrZip() {
        return strZip;
    }

    public String getstrPhoneNumber() {
        return strPhoneNumber;
    }

    public int getCustomerID() {
        return intCustomerID;
    }
}
