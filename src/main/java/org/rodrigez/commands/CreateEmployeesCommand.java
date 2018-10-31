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
        view.print("Enter employees names:\n");
        view.print("Customer name: ");
        String name = view.scanString();
        request.setAttribute("customer", new Customer(name));
        view.print("Manager name: ");
        name = view.scanString();
        request.setAttribute("manager", new Manager(name));
        view.print("Designer name: ");
        name = view.scanString();
        request.setAttribute("designer", new Designer(name));
        request.setAttribute("message", "Employees created successfully\n");
        executeNext(request);
    }
}