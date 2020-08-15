package case_study.models;

public class Villa extends Service {
    private String roomStandard;
    private String otherUtility;
    private String swimmingPoolArea;
    private String storyNumber;

    public Villa() {}

    //have extra service
    public Villa (String id, String serviceName, String usedArea,
                  String rentFee, String maxPeopleQuantity, String rentType,
                  String roomStandard, String otherUtility, String swimmingPoolArea, String storyNumber,
                  ExtraService extraService) {

        super(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType, extraService);
        this.roomStandard = roomStandard;
        this.otherUtility = otherUtility;
        this.swimmingPoolArea = swimmingPoolArea;
        this.storyNumber = storyNumber;
    }

    //Do not have extra service
    public Villa (String id, String serviceName, String usedArea, String rentFee,
                  String maxPeopleQuantity, String rentType,
                  String roomStandard, String otherUtility, String swimmingPoolArea,
                  String storyNumber) {

        super(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType);
        this.roomStandard = roomStandard;
        this.otherUtility = otherUtility;
        this.swimmingPoolArea = swimmingPoolArea;
        this.storyNumber = storyNumber;
    }

    //Constructor has 2 attribute: id and serviceName
    public Villa(String id, String serviceName) {
        super(id, serviceName);
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherUtility() {
        return otherUtility;
    }

    public void setOtherUtility(String otherUtility) {
        this.otherUtility = otherUtility;
    }

    public String getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(String swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public String getStoryNumber() {
        return storyNumber;
    }

    public void setStoryNumber(String storyNumber) {
        this.storyNumber = storyNumber;
    }

    @Override public void showInfo() {
        //System.out.println("<-- VILLA SERVICE -->");
        System.out.printf("%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-15s%-21s%-11s%s\n",id,
                serviceName, usedArea, rentType, maxPeopleQuantity, rentFee, roomStandard,
                otherUtility, swimmingPoolArea, storyNumber, extraService.getExtraServiceName(),
                extraService.getExtraServiceUnit(), extraService.getExtraServicePrice());
    }
}
