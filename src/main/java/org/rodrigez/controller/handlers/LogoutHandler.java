package org.rodrigez.controller.handlers;

import org.rodrigez.util.Request;
import org.rodrigez.view.page.MessagePage;

public class LogoutHandler extends Handler {
    @Override
    public void execute(Request request) {

        request.setAttribute("authorized","false");
        request.setAttribute("authorized-id",null);

        String message = "Log out successfully";

        new MessagePage().show(message);

        request.setAttribute("handler","menu");
    }
}
