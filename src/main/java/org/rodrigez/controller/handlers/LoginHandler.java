package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.view.form.LoginForm;

public class LoginHandler extends Handler {

    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);

    @Override
    public void execute(Request request) {

        new LoginForm().execute(request);

        int loginId = Integer.parseInt(request.getAttribute("login-id"));
        boolean authorized = employeeService.login(loginId);
        request.setAttribute("authorized", String.valueOf(authorized));
        if(authorized){
            System.out.println("Authorized successfully");
            request.setAttribute("authorized-id", String.valueOf(loginId));
        } else {
            System.out.println("Invalid employee Id");
        }

        request.setAttribute("handler","menu");
    }
}
