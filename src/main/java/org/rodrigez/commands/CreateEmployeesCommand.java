package org.rodrigez.commands;

import org.rodrigez.model.Customer;
import org.rodrigez.model.Designer;
import org.rodrigez.model.Manager;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.View;

public class CreateEmployeesCommand extends Command{
    @Override
    public void execute(Request request) throws RequestException {
        View view = (View) request.getAttribute("view");
        String name = (String) view.read("Customer name: ");
        request.setAttribute("customer", new Customer(name));
        name = (String) view.read("Manager name: ");
        request.setAttribute("manager", new Manager(name));
        name = (String) view.read("Designer name: ");
        request.setAttribute("designer", new Designer(name));
        request.setAttribute("message", "Employees created successfully\n");
        executeNext(request);
    }
}