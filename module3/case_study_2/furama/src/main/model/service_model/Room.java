package main.model.service_model;

public class Room extends Service {
    private String freeAttachedService;

    public Room() {
    }

    public Room(String serviceId, String serviceName, String serviceArea,
                String serviceCost, String serviceMaxPeople, String rentTypeId, String serviceTypeId) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
    }

    public String getFreeAttachedService() {
        return freeAttachedService;
    }

    public void setFreeAttachedService(String freeAttachedService) {
        this.freeAttachedService = freeAttachedService;
    }
}
