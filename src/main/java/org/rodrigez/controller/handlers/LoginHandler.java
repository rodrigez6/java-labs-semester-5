package org.rodrigez.controller.handlers;

import org.apache.log4j.Logger;
import org.rodrigez.model.Employee;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.validation.NotFoundException;
import org.rodrigez.view.form.LoginForm;
import org.rodrigez.view.page.MessagePage;

public class LoginHandler extends Handler {

    private final static Logger logger = Logger.getLogger(LoginHandler.class);

    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);

    @Override
    public void execute(Request request) {

        new LoginForm().execute(request);

        int loginId = Integer.parseInt(request.getAttribute("login-id"));

        String message;
        try {
            Employee employee = employeeService.findById(loginId);
            message = employee.getName() + " authorized successfully";
            logger.info(message);
            request.setAttribute("authorized-id", String.valueOf(loginId));
            request.setAttribute("authorized", String.valueOf(true));
        } catch (NotFoundException e) {
            message = e.getMessage();
            logger.info(message);

        }

        new MessagePage().show(message);

        request.setAttribute("handler","menu");
    }
}
