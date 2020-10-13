package vn.codegym.furama.model.sub_model;

import vn.codegym.furama.model.main_model.Service;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private List<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
