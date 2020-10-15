package vn.codegym.furama.model.main_model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attachServiceId;

    private String attachServiceName;
    private String attachServiceCost;
    private String attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;

    public AttachService() {
    }

    public AttachService(String attachServiceName, String attachServiceCost,
                         String attachServiceUnit, String attachServiceStatus) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
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
