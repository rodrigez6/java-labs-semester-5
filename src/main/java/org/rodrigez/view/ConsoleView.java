package org.rodrigez.view;

import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.view.messagetypes.MessageType;

public class ConsoleView implements View {
    @Override
    public void show(Request request) {
        try {
            MessageType messageType = (MessageType) request.getAttribute("messagetype");
            String message = (String) request.getAttribute("message");
            System.out.println(message);
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }
}
