package vn.codegym.furama.model.main_model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttachServiceFu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attachServiceId;

    private String attachServiceName;
    private String attachServiceCost;
    private String attachServiceUnit;
    private String attachServiceStatus;

    public AttachServiceFu() {
    }

    public AttachServiceFu(String attachServiceName, String attachServiceCost,
                           String attachServiceUnit, String attachServiceStatus) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public Long getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Long attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(String attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
