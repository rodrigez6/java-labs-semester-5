package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.EmployeeService;

import java.util.Scanner;

public class LoginHandler extends Handler {
    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.print("For login type your id: ");
        int loginId = scanner.nextInt();
        boolean authorized = employeeService.login(loginId);
        request.setAttribute("authorized", String.valueOf(authorized));
        if(authorized){
            request.setAttribute("authorized-id", String.valueOf(loginId));
        }

        request.setAttribute("handler","menu");
    }
}
