package main.model.service_model;

public class AttachService {
    private String attachServiceName;
    private String attachServiceUnit;
    private String attachServiceCost;
    private String attachServiceStatus;

    public AttachService() {
    }

    public AttachService(String attachServiceName, String attachServiceUnit, String attachServiceCost) {
        this.attachServiceName = attachServiceName;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(String attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
