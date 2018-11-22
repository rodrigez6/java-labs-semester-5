package org.rodrigez.controller.handlers;

import org.rodrigez.model.Role;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.EmployeeService;

public class MenuHandler extends Handler {
    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);

    @Override
    public void execute(Request request) {
        System.out.println("-----------------------------------------------------------------------------------------");
        boolean authorized = Boolean.parseBoolean(request.getAttribute("authorized"));

        if(authorized){

            int authorizedId = Integer.parseInt(request.getAttribute("authorized-id"));

            Role position = employeeService.findById(authorizedId).getRole();

            switch (position) {
                case CUSTOMER:{
                    request.setAttribute("handler","customer-menu");
                    break;
                }
                case MANAGER:{
                    request.setAttribute("handler","manager-menu");
                    break;
                }
                case DESIGNER:{
                    request.setAttribute("handler","designer-menu");
                    break;
                }
            }
        } else {
            request.setAttribute("handler","login");
        }
    }
}