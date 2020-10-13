package vn.codegym.furama.model.sub_model;

import vn.codegym.furama.model.main_model.Service;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentTypeId;
    private String rentTypeName;
    private String rentTypeCost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private List<Service> serviceList;
    public RentType() {
    }

    public RentType(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public RentType(String rentTypeName, String rentTypeCost) {
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public Long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Long rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public String getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(String rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
