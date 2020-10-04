package vn.codegym.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.restful.model.Customer;
import vn.codegym.restful.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomerList(){
        List<Customer> customerList = customerService.findAll();
        if(customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        Customer currentCustomer = customerService.findById(id);
        if(currentCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentCustomer.setName(customer.getName());
        currentCustomer.setAge(customer.getAge());

        customerService.save(currentCustomer);

        return new ResponseEntity<>(currentCustomer, HttpStatus.OK);

    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int id){
        Customer customer = customerService.findById(id);
        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable int id){
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerService.remove(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }
}
