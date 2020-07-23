package case_study.models;

public class Villa extends Services {
    private String roomStandard;
    private String otherUtility;
    private double swimmingPoolArea;
    private int storyNumber;

    public Villa() {}

    public Villa (String id, String serviceName, double usedArea, double rentAmount,
                  int maxPeopleQuantity, String rentType,
                  String roomStandard, String otherUtility, double swimmingPoolArea,
                  int storyNumber) {

        super(id, serviceName, usedArea, rentAmount, maxPeopleQuantity, rentType);

        this.roomStandard = roomStandard;
        this.otherUtility = otherUtility;
        this.swimmingPoolArea = swimmingPoolArea;
        this.storyNumber = storyNumber;

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
        System.out.println("<-- VILLA SERVICE -->");
        System.out.println("1. Id: " + this.id);
        System.out.println("2. Service name: " + this.serviceName);
        System.out.println("3. Used area: " + this.usedArea);
        System.out.println("4. Rent type: " + this.rentType);
        System.out.println("5. Max people quantity: " + this.maxPeopleQuantity);
        System.out.println("6. Rent amount: " + this.rentAmount);

        //show private information for villa only:
        System.out.println("7. Room standard: " + this.roomStandard);
        System.out.println("8. Other utility: " + this.otherUtility);
        System.out.println("9. Swimming pool area: " + this.swimmingPoolArea);
        System.out.println("10. Story number: " + this.storyNumber);

        //show extra service
        System.out.println("EXTRA SERVICE");
        System.out.println("1. Extra service name: " + this.extraServiceName);
        System.out.println("2. Extra service unit: " + this.extraServiceUnit);
        System.out.println("3. Extra service price: " + this.extraServiceUnit);

    }

    public static void main(String[] args) {
        Services villa = new Villa();
        villa.setServiceName("Villa");
        villa.showInfo();

    }
}
