package case_study.models;

public abstract class Services {
    String id;
    String serviceName;
    double usedArea;
    double rentAmount;
    int maxPeopleQuantity;
    String rentType;

    class attachedService{
        String typeName;
        String unit;
        Double price;
    }
    public abstract void showInfo();

}
