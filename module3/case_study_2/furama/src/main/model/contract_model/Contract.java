package main.model.contract_model;

public class Contract {
    private String contractId;//id
    private String contractStartDate; //a
    private String contractEndDate; //b
    private String contractDeposit; //c
    private String contractTotalMoney;  //d
    private String contractEmployeeId; //e
    private String contractCustomerId; //f
    private String contractServiceId; //g

    public Contract() {
    }

    public Contract(String contractId, String contractStartDate, String contractEndDate,
                    String contractDeposit, String contractTotalMoney,
                    String contractEmployeeId, String contractCustomerId, String contractServiceId) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.contractEmployeeId = contractEmployeeId;
        this.contractCustomerId = contractCustomerId;
        this.contractServiceId = contractServiceId;
    }

    public Contract(String contractStartDate, String contractEndDate,
                    String contractDeposit, String contractTotalMoney,
                    String contractEmployeeId, String contractCustomerId, String contractServiceId) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.contractEmployeeId = contractEmployeeId;
        this.contractCustomerId = contractCustomerId;
        this.contractServiceId = contractServiceId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public String getContractEmployeeId() {
        return contractEmployeeId;
    }

    public void setContractEmployeeId(String contractEmployeeId) {
        this.contractEmployeeId = contractEmployeeId;
    }

    public String getContractCustomerId() {
        return contractCustomerId;
    }

    public void setContractCustomerId(String contractCustomerId) {
        this.contractCustomerId = contractCustomerId;
    }

    public String getContractServiceId() {
        return contractServiceId;
    }

    public void setContractServiceId(String contractServiceId) {
        this.contractServiceId = contractServiceId;
    }
}
