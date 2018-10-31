package org.rodrigez.commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rodrigez.controller.Controller;
import org.rodrigez.model.*;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.ConsoleView;

class CommandTest {

    private static Request request = new Request();
    private static Controller controller = new Controller(new ConsoleView());
    private static Command command;

    @BeforeEach
    void setUp() {
        Project project = new BuildingProject(5,3,"Harmatna,3");
        request.setAttribute("specification", new Specification(project));
        request.setAttribute("customer", new Customer("Customer Petro"));
        request.setAttribute("manager", new Manager("Manager Ivan"));
        request.setAttribute("numberofdesigners",5);
        request.setAttribute("message","");

        command = new ProvideSpecificationCommand();
        command.linkWith(new RegisterSpecificationCommand()).
                linkWith(new BillTotalCostCommand()).
                linkWith(new CreateCrewCommand());
    }

    @Test
    void execute() throws RequestException {
        String type = command.execute(request);
        Assertions.assertEquals(type,"error");

        request.setAttribute("designer", new Designer("Designer Myroslav"));
        type = command.execute(request);
        Assertions.assertEquals(type,"info");
    }
}