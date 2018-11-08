package org.rodrigez.commands;

import org.rodrigez.routing.Request;

public class NoHandler extends Handler {
    @Override
    public void execute(Request request) {
        request.setAttribute("message","No such command");
    }
}
