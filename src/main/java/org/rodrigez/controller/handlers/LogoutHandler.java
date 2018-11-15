package org.rodrigez.controller.handlers;

import org.rodrigez.util.Request;

public class LogoutHandler extends Handler {
    @Override
    public void execute(Request request) {
        request.setAttribute("authorized","false");
        request.setAttribute("authorized-id",null);
        System.out.print("Log out successfully\n");

        request.setAttribute("handler","menu");
    }
}
