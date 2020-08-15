package case_study.models;

public abstract class Service {
    protected String id;
    protected String serviceName;
    protected String usedArea;
    protected String rentFee;
    protected String maxPeopleQuantity;
    protected String rentType;
    protected ExtraService extraService;

    public Service() {
    }

    //Constructor do not have ExtraService
    public Service(String id, String serviceName, String usedArea,
                   String rentFee, String maxPeopleQuantity, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.usedArea = usedArea;
        this.rentFee = rentFee;
        this.maxPeopleQuantity = maxPeopleQuantity;
        this.rentType = rentType;
    }

    //Constructor has ExtraService
    public Service(String id, String serviceName, String usedArea,
                   String rentFee, String maxPeopleQuantity, String rentType, ExtraService extraService) {
        this(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType);
        this.extraService = extraService;
    }

    //Constructor has 2 attribute: id and serviceName
    public Service(String id, String serviceName){
        this.id = id;
        this.serviceName = serviceName;
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

    public String getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(String usedArea) {
        this.usedArea = usedArea;
    }

    public String getRentFee() {
        return rentFee;
    }

    public void setRentFee(String rentFee) {
        this.rentFee = rentFee;
    }

    public String getMaxPeopleQuantity() {
        return maxPeopleQuantity;
    }

    public void setMaxPeopleQuantity(String maxPeopleQuantity) {
        this.maxPeopleQuantity = maxPeopleQuantity;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    public abstract void showInfo();
}
