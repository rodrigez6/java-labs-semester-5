package org.rodrigez.controller.handlers;

import org.rodrigez.service.SpecificationService;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.form.RegisterSpecificationForm;
import org.rodrigez.view.page.MessagePage;

public class RegisterSpecificationHandler implements Handler {

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);

    @Override
    public void execute(Request request){

        new RegisterSpecificationForm().execute(request);

        int designerId = Integer.parseInt(request.getAttribute("designer-id"));
        int managerId = Integer.parseInt(request.getAttribute("authorized-id"));

        String message;
        try {
            specificationService.registerAll(managerId, designerId);
            message = resourceManager.getString("OK");
        } catch (NotFoundException e) {
            message = resourceManager.getString("Not_Found");
        } catch (NotAllowedException e) {
            message = resourceManager.getString("Not_Allowed");
        }

        new MessagePage().show(message);

        request.setAttribute("handler", "menu");
    }

}