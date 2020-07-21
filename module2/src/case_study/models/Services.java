package case_study.models;

public abstract class Services {
    protected String id;
    protected String serviceName;
    protected double usedArea;
    protected double rentAmount;
    protected int maxPeopleQuantity;
    protected String rentType;

    public Services() {};

    public Services (String id, String serviceName, double usedArea, double rentAmount,
                     int maxPeopleQuantity, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.usedArea = usedArea;
        this.rentAmount = rentAmount;
        this.maxPeopleQuantity = maxPeopleQuantity;
        this.rentType = rentType;
    }

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

    public double getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(double usedArea) {
        this.usedArea = usedArea;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public int getMaxPeopleQuantity() {
        return maxPeopleQuantity;
    }

    public void setMaxPeopleQuantity(int maxPeopleQuantity) {
        this.maxPeopleQuantity = maxPeopleQuantity;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    /* May use Enumeration to create extraServices for all services */
    static class ExtraService {
        String typeName;
        int unit;
        Double price;

        public ExtraService() {}

        public ExtraService (String typeName, int unit, double price) {
            this.typeName = typeName;
            this.unit = unit;
            this.price = price;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "<-- ExtraService -->" + "\n" +
                    "Type Name: '" + typeName + "\n" +
                    "Unit: " + unit + "\n" +
                    "Price: " + price;
        }
    }

    public abstract void showInfo();
}
