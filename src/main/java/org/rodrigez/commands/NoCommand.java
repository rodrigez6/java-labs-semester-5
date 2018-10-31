package org.rodrigez.commands;

import org.rodrigez.routing.Request;

public class NoCommand extends Command {
    @Override
    public String execute(Request request) {
        request.setAttribute("message","No such command");
        return "error";
    }
}
