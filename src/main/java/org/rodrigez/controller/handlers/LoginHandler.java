package org.rodrigez.controller.handlers;

import org.apache.log4j.Logger;
import org.rodrigez.model.Employee;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.service.exception.NotFoundException;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.form.LoginForm;
import org.rodrigez.view.page.MessagePage;

public class LoginHandler implements Handler {

    private final static Logger logger = Logger.getLogger(LoginHandler.class);

    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);
    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);

    @Override
    public void execute(Request request) {

        new LoginForm().execute(request);

        int loginId = Integer.parseInt(request.getAttribute("login-id"));

        String message;
        try {
            Employee employee = employeeService.findById(loginId);
            message = resourceManager.getString("Log_In_OK");
            logger.info(employee.getName() + "authorized");
            request.setAttribute("authorized-id", String.valueOf(loginId));
            request.setAttribute("authorized", String.valueOf(true));
        } catch (NotFoundException e) {
            message = resourceManager.getString("Log_In_Error");
            logger.info(e.getMessage());

        }

        new MessagePage().show(message);

        request.setAttribute("handler","menu");
    }

}
