package org.rodrigez.commands;

import org.rodrigez.model.Customer;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.CustomerService;

public class ProvideSpecificationCommand extends Command {
    @Override
    public String execute(Request request) throws RequestException {
        try{
            Customer customer = (Customer) request.getAttribute("customer");
            Specification specification = (Specification) request.getAttribute("specification");
            CustomerService customerService = new CustomerService();
            customerService.provideSpecification(customer,specification);
            String oldmsg = (String) request.getAttribute("message");
            String msg = customer.getName() + " provided specification for project:\n   " + specification.getProject().getDescription();
            request.setAttribute("message", oldmsg + "\n" + msg);
        } catch (RequestException e){
            request.setAttribute("message",e.toString());
            return "error";
        }
        return executeNext(request);
    }
}
