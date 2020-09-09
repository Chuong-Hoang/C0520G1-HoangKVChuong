package main.model.service_model;

public class Villa extends Service {
    private String standardRoom; //g
    private String descriptionOtherConvenience; //h
    private String poolArea; //i
    private String numberOfFloors; //j

    public Villa() {
    }

    public Villa(String serviceId, String serviceName, String serviceArea,
                 String serviceCost, String serviceMaxPeople, String rentTypeId, String serviceTypeId,
                 String standardRoom, String descriptionOtherConvenience, String poolArea, String numberOfFloors) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
