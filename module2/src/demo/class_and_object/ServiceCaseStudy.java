package demo.class_and_object;

import case_study.models.ExtraService;

public abstract class ServiceCaseStudy {
    protected String id;
    protected String serviceName;
    protected double usedArea;
    protected double rentFee;
    protected int maxPeopleQuantity;
    protected String rentType;
    protected ExtraService extraService;

    public ServiceCaseStudy() {
    }

    //Constructor do not have ExtraService
    public ServiceCaseStudy(String id, String serviceName, double usedArea,
                            double rentFee, int maxPeopleQuantity, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.usedArea = usedArea;
        this.rentFee = rentFee;
        this.maxPeopleQuantity = maxPeopleQuantity;
        this.rentType = rentType;
    }

    //Constructor has ExtraService
    public ServiceCaseStudy(String id, String serviceName, double usedArea,
                            double rentFee, int maxPeopleQuantity, String rentType, ExtraService extraService) {
        this(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType);
        this.extraService = extraService;
    }

    //Constructor has 2 attribute: id and serviceName
    public ServiceCaseStudy(String id, String serviceName){
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

    public double getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(double usedArea) {
        this.usedArea = usedArea;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
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

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    public abstract void showInfo();
}
