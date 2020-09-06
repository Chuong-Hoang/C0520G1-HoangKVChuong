package main.bo.service_bo;


import main.model.service_model.Service;

import java.util.Comparator;

public class ServiceSortByNameBO implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
        return o1.getServiceName().compareTo(o2.getServiceName());
    }
}
