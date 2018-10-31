package org.rodrigez.app;

import org.rodrigez.commands.*;
import org.rodrigez.controller.Controller;
import org.rodrigez.model.*;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.ConsoleView;

public class Demo {

    private static Request request = new Request();
    private static Controller controller = new Controller(new ConsoleView());

    public static void main(String args[]) throws RequestException {
        Project project = new BuildingProject(5,3,"Harmatna,3");
        request.setAttribute("specification", new Specification(project));
        request.setAttribute("customer", new Customer("Customer Petro"));
        request.setAttribute("manager", new Manager("Manager Ivan"));
        request.setAttribute("designer", new Designer("Designer Myroslav"));
        request.setAttribute("numberofdesigners",5);
        request.setAttribute("message","");

        Command command = new ProvideSpecificationCommand();
        command.linkWith(new RegisterSpecificationCommand()).
                linkWith(new BillTotalCostCommand()).
                linkWith(new CreateCrewCommand());

        request.setAttribute("command",command);
        controller.execute(request);

    }
}
