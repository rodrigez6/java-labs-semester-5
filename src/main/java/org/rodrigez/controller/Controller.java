package org.rodrigez.controller;

import org.rodrigez.commands.Command;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.MessageTypeManager;
import org.rodrigez.view.View;
import org.rodrigez.view.messagetypes.MessageType;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void execute(Request request) throws RequestException {
        Command command = (Command) request.getAttribute("command");
        String type = command.execute(request);
        MessageType messageType = MessageTypeManager.getInstance().getMessageType(type);
        request.setAttribute("messagetype",messageType);
        view.show(request);
    }
}