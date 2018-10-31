package org.rodrigez.commands;

import org.rodrigez.routing.Request;

public class NoCommand extends Command {
    @Override
    public void execute(Request request) {
        request.setAttribute("message","No such command");
    }
}
