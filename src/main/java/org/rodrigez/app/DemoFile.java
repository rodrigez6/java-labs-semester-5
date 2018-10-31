package org.rodrigez.app;

import org.rodrigez.commands.CreateEmployeesCommand;
import org.rodrigez.controller.Controller;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.FileView;
import org.rodrigez.view.View;

public class DemoFile {

    private static Request request = new Request();
    private static Controller controller = new Controller();

    public static void main(String args[]) throws RequestException {
        View view = new FileView("src\\main\\resources\\in.txt","src\\main\\resources\\out.txt","String");
        request.setAttribute("command",new CreateEmployeesCommand());
        request.setAttribute("view",view);
        controller.execute(request);
    }
}
