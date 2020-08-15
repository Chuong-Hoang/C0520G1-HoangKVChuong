package case_study.models;

public class Constant {
    // Delimiter used in CSV files
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";

    //public static final variables
    //*************************************************************************************************/
    public static final String STR_A = "Service_Id: ";
    public static final String STR_B = "Service_Name: ";
    public static final String STR_C = "Used_Area: ";
    public static final String STR_D = "Rent_Type (Hourly/Daily/Monthly/Yearly): ";
    public static final String STR_E = "Max_People_Q'ty: ";
    public static final String STR_F = "Rent_Fee: ";
    public static final String STR_VH1 = "Room_Standard (Vip/Business/Normal): ";
    public static final String STR_VH2 = "Other_Utility (1.Free Laundry/2.Free Buffet/3.Free Massage/4.Free Beverage): ";
    public static final String STR_V3 = "Swimming_Pool_Area";
    public static final String STR_VH4 = "Story_Number: ";
    public static final String STR_R1 = "Free_Service: ";
    public static final String STR_E1 = "Extra_Service_Name (Karaoke/Massage/Food/Drink/Car): ";
    public static final String STR_E2 = "Extra_Service_Unit (1.Hour/2.Day/3.Set/4.Combo): ";
    public static final String STR_E3 = "Extra_Service_Price (1.$50/2.$150/3.$500/4.$750/5.$1000): ";
    public static final String INPUT = "Input ";
    public static final String ID_VILLA_INVALID = "-->Input failed! Service Id must be as format 'SVVL-YYYY'";
    public static final String ID_HOUSE_INVALID = "-->Input failed! Service Id must be as format 'SVHO-YYYY'";
    public static final String ID_ROOM_INVALID = "-->Input failed! Service Id must be as format 'SVRO-YYYY'";
    public static final String NAME_INVALID = "-->Input failed! Service Name must follow Camelcase";
    public static final String AREA_INVALID = "-->Input failed! Used area must be float number that greater than 30m2.";
    public static final String RENT_TYPE_INVALID = "-->Input failed! Rent Type must follow Camelcase";
    public static final String MAX_QTY_INVALID = "-->Input failed! Max people number must be positive and less than 20.";
    public static final String RENT_FEE_INVALID = "-->Input failed! Rent fee must be a positive number.";
    public static final String ROOM_STANDARD_INVALID = "-->Input failed! Room standard must follow Camelcase.";
    public static final String STORY_NUMBER_INVALID = "-->Input failed! Story number must be a positive integer.";
    //**************************************************************************************************/

    // File paths
    public static final String VILLA_FILE_PATH = "src/case_study/data/Villa.csv";
    public static final String HOUSE_FILE_PATH = "src/case_study/data/House.csv";
    public static final String ROOM_FILE_PATH = "src/case_study/data/Room.csv";

    // File header in CSV files
    public static final String VILLA_FILE_HEADER = "Id,Service_Name,Used_Area,Rent_Fee,Max_People,Rent_Type," +
            "Room_Standard,Other_Utility,Swimming_Pool_Area,Story_Number," +
            "Extra_Service_Name,Extra_Service_Unit,Extra_Service_Price";

    public static final String HOUSE_FILE_HEADER = "Id,Service_Name,Used_Area,Rent_Fee,Max_People,Rent_Type," +
            "Room_Standard,Other_Utility,Story_Number," +
            "Extra_Service_Name,Extra_Service_Unit,Extra_Service_Price";

    public static final String ROOM_FILE_HEADER = "Id,Service_Name,Used_Area,Rent_Fee,Max_People,Rent_Type," +
            "Free_Service," +
            "Extra_Service_Name,Extra_Service_Unit,Extra_Service_Price";

    // Some message
    public static final String ELEMENT_ALREADY_EXISTS = "-->This element is already in the list. Please input another.";
    public static final String NEW_ELEMENT_ADDED = "-->New element has been added to the list.";
    public static final String CANNOT_FIND_ELEMENT = "-->Cannot find any element. The list is empty.";
    public static final String ELEMENT_NOT_FOUND = "-->Element NOT found in the list.";
    public static final String CANNOT_DELETE_ELEMENT = "-->Cannot delete any element. The list is empty.";
    public static final String DELETE_OR_NOT = "Delete this element? Yes(y) or No(n)? ";
    public static final String NO_ELEMENT_DELETED = "No element deleted at all.";
    public static final String FILE_NOT_FOUND = "The file does not exist.";
    public static final String LIST_IS_EMPTY = "The list is empty. Please add new element.";
    public static final String LIST_BEGUN = "________________________ Elements list __________________________";
    public static final String LIST_ENDED = "........................... End list ............................";
    public static final String RESULT = "The result found:";
    public static final String RESULT_UPDATE = "The new update result:";
    public static final String YES = "Y".toLowerCase();

}
