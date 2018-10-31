package org.rodrigez.commands;

import org.rodrigez.model.Customer;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.CustomerService;

public class ProvideSpecificationCommand extends Command {
    @Override
    public void execute(Request request) {
        try {
            Customer customer = (Customer) request.getAttribute("customer");
            Specification specification = (Specification) request.getAttribute("specification");
            CustomerService customerService = new CustomerService();
            customerService.provideSpecification(customer,specification);
            String message = customer.getName() + " provided specification for project:\n   " + specification.getProject().getDescription() + "\n";
            request.setAttribute("message", message);
        } catch (RequestException e){
            request.setAttribute("message",e.getMessage());
        }

    }
}
