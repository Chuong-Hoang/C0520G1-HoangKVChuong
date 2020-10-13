package vn.codegym.furama.model.sub_model;
import vn.codegym.furama.model.main_model.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerTypeId;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public CustomerType(Long customerTypeId, String customerTypeName) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
