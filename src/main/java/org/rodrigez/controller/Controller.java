package org.rodrigez.controller;

import org.rodrigez.commands.Command;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.View;

public class Controller {
    public Controller(){
    }

    public void execute(Request request) throws RequestException {
        Command command = (Command) request.getAttribute("command");
        request.setAttribute("message", "");
        command.execute(request);
        View view = (View) request.getAttribute("view");
        String message = (String) request.getAttribute("message");
        view.write(message);
    }
}