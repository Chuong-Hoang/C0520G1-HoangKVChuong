package main.model.amount_model;

public class Amount {
    private String customerId;
    private String customerName;
    private String contractId;
    private String serviceId;
    private String serviceName;

    private String contractTotalMoney;
    private String attachServiceTotalMoney;


//    private String contractDetailId;
//    private String attachServiceId;
//    private String attachServiceName;
//    private String attachServiceCost;
//    private String quantity;


    public Amount() {
    }

    public Amount(String customerId, String customerName, String contractId, String serviceId,
                  String serviceName, String contractTotalMoney, String attachServiceTotalMoney) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contractId = contractId;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.contractTotalMoney = contractTotalMoney;
        this.attachServiceTotalMoney = attachServiceTotalMoney;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public String getAttachServiceTotalMoney() {
        return attachServiceTotalMoney;
    }

    public void setAttachServiceTotalMoney(String attachServiceTotalMoney) {
        this.attachServiceTotalMoney = attachServiceTotalMoney;
    }
}
