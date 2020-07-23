package case_study.models;

public abstract class Services {
    protected String id;
    protected String serviceName;
    protected double usedArea;
    protected double rentAmount;
    protected int maxPeopleQuantity;
    protected String rentType;

    // Extra service
    protected String extraServiceName;
    protected String extraServiceUnit;
    protected double extraServicePrice;


    public Services() {};

    public Services (String id, String serviceName, double usedArea, double rentAmount,
                     int maxPeopleQuantity, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.usedArea = usedArea;
        this.rentAmount = rentAmount;
        this.maxPeopleQuantity = maxPeopleQuantity;
        this.rentType = rentType;
    }

    //constructor for extra service


    public Services(String extraServiceName, String extraServiceUnit, double extraServicePrice) {
        this.extraServiceName = extraServiceName;
        this.extraServiceUnit = extraServiceUnit;
        this.extraServicePrice = extraServicePrice;
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(double usedArea) {
        this.usedArea = usedArea;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public int getMaxPeopleQuantity() {
        return maxPeopleQuantity;
    }

    public void setMaxPeopleQuantity(int maxPeopleQuantity) {
        this.maxPeopleQuantity = maxPeopleQuantity;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    /*Extra services - getter and setter */
    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public String getExtraServiceUnit() {
        return extraServiceUnit;
    }

    public void setExtraServiceUnit(String extraServiceUnit) {
        this.extraServiceUnit = extraServiceUnit;
    }

    public double getExtraServicePrice() {
        return extraServicePrice;
    }

    public void setExtraServicePrice(double extraServicePrice) {
        this.extraServicePrice = extraServicePrice;
    }

    public abstract void showInfo();
}
