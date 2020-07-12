package abc_case_study.models;

public class Villa extends Services {
//    public Villa (String id, String serviceName, double usedArea, double rentAmount,
//                  int maxPeopleQuantity, String rentType){
//        super.id = id;
//        super.serviceName = serviceName;
//        super.usedArea = usedArea;
//        super.rentFee = rentAmount;
//        super.maxPeopleQuantity = maxPeopleQuantity;
//        super.rentType = rentType;

//    }
    public Villa(){};

    @Override public void showInfo() {
        System.out.println("INFORMATION OF VILLA");
        System.out.println("Id: " + this.id);
        System.out.println("Service name: " + this.serviceName);
        System.out.println("Used area: " + this.usedArea);
        System.out.println("Rent type: " + this.rentType);
        System.out.println("Max people quantity: " + this.maxPeopleQuantity);
        System.out.println("Rent amount: " + this.rentAmount);

    }

    public static void main(String[] args) {
        Services villa = new Villa();
        villa.showInfo();
    }
}
