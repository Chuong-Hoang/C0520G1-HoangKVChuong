package case_study.models;

public abstract class Service {
    protected String id;
    protected String serviceName;
    protected String usedArea;
    protected String rentFee;
    protected String maxPeopleQuantity;
    protected String rentType;
    protected ExtraService extraService;

    //public static final variables
    //*************************************************************************************************/
    public static final String strA = "Service_Id: ";
    public static final String strB = "Service_Name: ";
    public static final String strC = "Used_Area: ";
    public static final String strD = "Rent_Type (Hourly/Daily/Monthly/Yearly): ";
    public static final String strE = "Max_People_Q'ty: ";
    public static final String strF = "Rent_Fee: ";
    public static final String strVH1 = "Room_Standard (Vip/Business/Normal): ";
    public static final String strVH2 = "Other_Utility (1.Free Laundry/2.Free Buffet/3.Free Massage/4.Free Beverage): ";
    public static final String strV3 = "Swimming_Pool_Area";
    public static final String strVH4 = "Story_Number: ";
    public static final String strR1 = "Free_Service: ";
    public static final String strE1 = "Extra_Service_Name (Karaoke/Massage/Food/Drink/Car): ";
    public static final String strE2 = "Extra_Service_Unit (1.Hour/2.Day/3.Set/4.Combo): ";
    public static final String strE3 = "Extra_Service_Price (1.$50/2.$150/3.$500/4.$750/5.$1000): ";
    public static final String input = "Input ";
    public static final String idVillaNotValid = "-->Input failed! Service Id must be as format 'SVVL-YYYY'";
    public static final String idHouseNotValid = "-->Input failed! Service Id must be as format 'SVHO-YYYY'";
    public static final String idRoomNotValid = "-->Input failed! Service Id must be as format 'SVRO-YYYY'";
    public static final String nameNotValid = "-->Input failed! Service Name must follow Camelcase";
    public static final String areaNotValid = "-->Input failed! Used area must be float number that greater than 30m2.";
    public static final String rentTypeNotValid = "-->Input failed! Rent Type must follow Camelcase";
    public static final String maxQtyNotValid = "-->Input failed! Max people number must be positive and less than 20.";
    public static final String rentFeeNotValid = "-->Input failed! Rent fee must be a positive number.";
    public static final String roomStandardNotValid = "-->Input failed! Room standard must follow Camelcase.";
    public static final String storyNumberNotValid = "-->Input failed! Story number must be a positive integer.";
    //**************************************************************************************************/

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
