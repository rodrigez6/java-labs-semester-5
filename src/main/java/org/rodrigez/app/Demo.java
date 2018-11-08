package org.rodrigez.app;

import org.rodrigez.commands.*;
import org.rodrigez.controller.Controller;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.ModelException;
import org.rodrigez.view.FileView;

public class Demo {

    private static Request request = new Request();
    private static Controller controller = new Controller();

    public static void main(String args[]) throws ModelException {

        String[] handlers = new String[]{
                "create-specification","provide-specification","register-specification",
                "bill-cost","create-crew"};

        for(String handler : handlers){
            run(handler);
        }
    }

    private static void run(String handler) throws ModelException {
        request.setAttribute("handler", handler);
        controller.execute(request);
    }
}