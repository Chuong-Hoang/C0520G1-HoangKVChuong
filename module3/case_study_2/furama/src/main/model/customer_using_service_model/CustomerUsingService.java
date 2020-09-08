package main.model.customer_using_service_model;

public class CustomerUsingService {
    private String customerId;
    private String customerName;
    private String contractId;
    private String contractDetailId;
    private String serviceId;
    private String serviceName;
    private String attachServiceId;
    private String attachServiceName;

    public CustomerUsingService() {
    }

    public CustomerUsingService(String customerId, String customerName, String contractId,
                                String contractDetailId, String serviceId, String serviceName,
                                String attachServiceId, String attachServiceName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contractId = contractId;
        this.contractDetailId = contractDetailId;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
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

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId;
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

    public String getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(String attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }
}


//customer.customer_id,
// customer.customer_name,
// contract.contract_id,
// contract_detail.contract_detail_id,
//	contract.service_id,
//	service.service_name,
//	attach_service.attach_service_id,
//	attach_service.attach_service_name