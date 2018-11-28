package org.rodrigez.controller.handlers;

import org.apache.log4j.Logger;
import org.rodrigez.model.Role;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.EmployeeService;
import org.rodrigez.validation.NotFoundException;

public class MenuHandler extends Handler {

    private static final Logger logger = Logger.getLogger(MenuHandler.class);

    private EmployeeService employeeService = BeanStorage.INSTANCE.get(EmployeeService.class);

    @Override
    public void execute(Request request) {

        boolean authorized = Boolean.parseBoolean(request.getAttribute("authorized"));

        if(authorized){

            int authorizedId = Integer.parseInt(request.getAttribute("authorized-id"));

            try {
                Role position = employeeService.findById(authorizedId).getRole();

                switch (position) {
                    case CUSTOMER:{
                        request.setAttribute("handler","customer-menu"); break;
                    }
                    case MANAGER:{
                        request.setAttribute("handler","manager-menu"); break;
                    }
                    case DESIGNER:{
                        request.setAttribute("handler","designer-menu"); break;
                    }
                }
            } catch (NotFoundException e) {
                logger.error("User with authorized id not found");
            }

        } else {
            request.setAttribute("handler","login");
        }
    }
}