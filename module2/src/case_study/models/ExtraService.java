package case_study.models;

public class ExtraService {
    protected String extraServiceName;
    protected String extraServiceUnit;
    protected String extraServicePrice;

    public ExtraService() {
        this.extraServiceName = "N/A";
        this.extraServiceUnit = "N/A";
        this.extraServicePrice = "N/A";
    }

    public ExtraService(String extraServiceName, String extraServiceUnit, String extraServicePrice) {
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

    public String getExtraServicePrice() {
        return extraServicePrice;
    }

    public void setExtraServicePrice(String extraServicePrice) {
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
