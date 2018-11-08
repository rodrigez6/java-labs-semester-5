package org.rodrigez.app;

import org.rodrigez.controller.Controller;
import org.rodrigez.model.Manager;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.ModelException;
import org.rodrigez.view.FileView;
import org.rodrigez.view.View;

public class DemoFile {

    private static Request request = new Request();
    private static Controller controller = new Controller();

    public static void main(String args[]) throws ModelException {
        View view = new FileView("String");
        Manager manager = (Manager) view.read(Manager.class);
        System.out.println(manager.getName());
    }
}
