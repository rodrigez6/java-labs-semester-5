package org.rodrigez.controller.handlers;

import org.apache.log4j.Logger;
import org.rodrigez.model.Employee;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.util.Request;
import org.rodrigez.view.page.MessagePage;

public class LogoutHandler extends Handler {

    private final static Logger logger = Logger.getLogger(LogoutHandler.class);

    @Override
    public void execute(Request request) {

        request.setAttribute("authorized","false");
        request.setAttribute("authorized-id",null);

        String message = "Log out successfully";

        logger.info(message);

        new MessagePage().show(message);

        request.setAttribute("handler","menu");
    }
}
