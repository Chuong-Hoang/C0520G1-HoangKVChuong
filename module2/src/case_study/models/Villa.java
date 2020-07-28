package case_study.models;

public class Villa extends Services {
    private String roomStandard;
    private String otherUtility;
    private double swimmingPoolArea;
    private int storyNumber;

    public Villa() {}

    //have extra service
    public Villa (String id, String serviceName, double usedArea,
                  double rentFee, int maxPeopleQuantity, String rentType,
                  String roomStandard, String otherUtility, double swimmingPoolArea, int storyNumber,
                  ExtraService extraService) {

        super(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType, extraService);
        this.roomStandard = roomStandard;
        this.otherUtility = otherUtility;
        this.swimmingPoolArea = swimmingPoolArea;
        this.storyNumber = storyNumber;
    }

    //Do not have extra service
    public Villa (String id, String serviceName, double usedArea, double rentFee,
                  int maxPeopleQuantity, String rentType,
                  String roomStandard, String otherUtility, double swimmingPoolArea,
                  int storyNumber) {

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

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getStoryNumber() {
        return storyNumber;
    }

    public void setStoryNumber(int storyNumber) {
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
