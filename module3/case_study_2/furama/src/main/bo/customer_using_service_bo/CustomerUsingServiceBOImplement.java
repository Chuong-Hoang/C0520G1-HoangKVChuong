package main.bo.customer_using_service_bo;

import main.dao.customer_using_service_dao.CustomerUsingServiceDAOImplement;
import main.model.customer_using_service_model.CustomerUsingService;

import java.util.List;

public class CustomerUsingServiceBOImplement implements CustomerUsingServiceBO {
    CustomerUsingServiceDAOImplement customerUsingServiceDAO = new CustomerUsingServiceDAOImplement();
    @Override
    public List<CustomerUsingService> findAll() {
        return this.customerUsingServiceDAO.findAll();
    }
}
