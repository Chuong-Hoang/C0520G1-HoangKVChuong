package main.model.service_model;

public class House extends Service {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String numberOfFloors;

    public House() {
    }

    public House(String serviceId, String serviceName, String serviceArea,
                 String serviceCost, String serviceMaxPeople, String rentTypeId,String serviceTypeId,
                 String standardRoom, String descriptionOtherConvenience, String numberOfFloors) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
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

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
