package org.rodrigez.service;

import org.rodrigez.model.Customer;
import org.rodrigez.model.Specification;

public class CustomerService {
    public void provideSpecification(Customer customer,Specification specification){
        specification.setCustomer(customer);
    }
}
