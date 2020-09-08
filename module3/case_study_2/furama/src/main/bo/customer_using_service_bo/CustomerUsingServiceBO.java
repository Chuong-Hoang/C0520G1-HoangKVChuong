package main.bo.customer_using_service_bo;

import main.model.customer_using_service_model.CustomerUsingService;

import java.util.List;

public interface CustomerUsingServiceBO {
    List<CustomerUsingService> findAll();
}
