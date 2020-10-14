package vn.codegym.furama.model.main_model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractDetailId;
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "attachServiceId")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contractId")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(String quantity, Contract contract) {
        this.quantity = quantity;
        this.contract = contract;
    }

    public ContractDetail(String quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
