package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;
import org.rodrigez.view.form.RegisterSpecificationForm;
import org.rodrigez.view.page.MessagePage;

public class RegisterSpecificationHandler implements Handler {

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request){

        new RegisterSpecificationForm().execute(request);

        int designerId = Integer.parseInt(request.getAttribute("designer-id"));
        int managerId = Integer.parseInt(request.getAttribute("authorized-id"));

        String message;
        try {
            specificationService.registerAll(managerId, designerId);
            message = "Operation is successful";
        } catch (NotFoundException | NotAllowedException e) {
            message = e.getMessage();
        }

        new MessagePage().show(message);

        request.setAttribute("handler", "menu");
    }

}