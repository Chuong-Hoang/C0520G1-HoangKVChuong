package case_study.models;

public class Room extends Service {
    private String freeService;

    public Room() {}

    //Constructor has extra service
    public Room(String id, String serviceName, String usedArea,
                String rentFee, String maxPeopleQuantity, String rentType, String freeService,
                  ExtraService extraService) {

        super(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType, extraService);
        this.freeService = freeService;
    }

    //Constructor do not have extra service
    public Room(String id, String serviceName, String usedArea, String rentFee,
                String maxPeopleQuantity, String rentType, String freeService) {

        super(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType);
        this.freeService = freeService;
    }

    //Constructor has 2 attribute: id and serviceName
    public Room(String id, String serviceName) {
        super(id, serviceName);
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override public void showInfo() {
        //System.out.println("<-- ROOM SERVICE -->");
        System.out.printf("%-12s%-15s%-12s%-14s%-14s%-12s%-15s%-21s%-11s%s\n",id, serviceName, usedArea, rentType,
                maxPeopleQuantity, rentFee, freeService, extraService.getExtraServiceName(),
                extraService.getExtraServiceUnit(), extraService.getExtraServicePrice());
    }
}
