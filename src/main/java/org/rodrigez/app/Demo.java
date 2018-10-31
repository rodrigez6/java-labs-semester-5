package org.rodrigez.app;

import org.rodrigez.commands.*;
import org.rodrigez.controller.Controller;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.ConsoleView;

public class Demo {

    private static Request request = new Request();
    private static Controller controller = new Controller();

    public static void main(String args[]) throws RequestException {
        request.setAttribute("view", new ConsoleView());
        request.setAttribute("command", new CreateBuildingProjectCommand());
        controller.execute(request);
        request.setAttribute("command", new CreateSpecificationCommand());
        controller.execute(request);
        request.setAttribute("command", new CreateEmployeesCommand());
        controller.execute(request);
        request.setAttribute("command",new ProvideSpecificationCommand());
        controller.execute(request);
        request.setAttribute("command",new RegisterSpecificationCommand());
        controller.execute(request);
        request.setAttribute("command",new BillTotalCostCommand());
        controller.execute(request);
        request.setAttribute("command", new CreateCrewCommand());
        controller.execute(request);
    }
}