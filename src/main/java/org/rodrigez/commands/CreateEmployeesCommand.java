package org.rodrigez.commands;

import org.rodrigez.model.Customer;
import org.rodrigez.model.Designer;
import org.rodrigez.model.Manager;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.View;

public class CreateEmployeesCommand extends Command{
    @Override
    public void execute(Request request){
        try{
            View view = (View) request.getAttribute("view");
            request.setAttribute("customer", view.read(Customer.class));
            request.setAttribute("manager", view.read(Manager.class));
            request.setAttribute("designer", view.read(Designer.class));
            request.setAttribute("message", "Employees created successfully\n");
        } catch (RequestException e){
            request.setAttribute("message",e.getMessage());
        }

    }
}