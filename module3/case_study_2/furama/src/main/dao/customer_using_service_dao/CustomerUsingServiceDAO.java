package main.dao.customer_using_service_dao;

import main.model.customer_using_service_model.CustomerUsingService;

import java.util.List;

public interface CustomerUsingServiceDAO {
    List<CustomerUsingService> findAll();
}
