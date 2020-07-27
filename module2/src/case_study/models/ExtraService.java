package case_study.models;

public class ExtraService {
    protected String extraServiceName;
    protected String extraServiceUnit;
    protected double extraServicePrice;

    public ExtraService() {
        this.extraServiceName = "N/A";
        this.extraServiceUnit = "N/A";
        this.extraServicePrice = 0.0;
    }

    public ExtraService(String extraServiceName, String extraServiceUnit, double extraServicePrice) {
        this.extraServiceName = extraServiceName;
        this.extraServiceUnit = extraServiceUnit;
        this.extraServicePrice = extraServicePrice;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public String getExtraServiceUnit() {
        return extraServiceUnit;
    }

    public void setExtraServiceUnit(String extraServiceUnit) {
        this.extraServiceUnit = extraServiceUnit;
    }

    public double getExtraServicePrice() {
        return extraServicePrice;
    }

    public void setExtraServicePrice(double extraServicePrice) {
        this.extraServicePrice = extraServicePrice;
    }

    @Override
    public String toString() {
        return  "\t" +
                extraServiceName + "\t" +
                extraServiceUnit + "\t" +
                extraServicePrice;
    }
}
