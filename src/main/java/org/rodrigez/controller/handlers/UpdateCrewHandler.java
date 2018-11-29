package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.service.exception.NotAllowedException;
import org.rodrigez.service.exception.NotFoundException;
import org.rodrigez.view.form.UpdateCrewForm;
import org.rodrigez.view.page.MessagePage;

public class UpdateCrewHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request){

        new UpdateCrewForm().execute(request);

        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));
        int size = Integer.parseInt(request.getAttribute("size"));
        int designerId = Integer.parseInt(request.getAttribute("authorized-id"));

        String message;
        try {
            specificationService.updateCrew(designerId,specificationId,size);
            message = "Operation is successful";
        } catch (NotFoundException | NotAllowedException e) {
            message = e.getMessage();
        }

        new MessagePage().show(message);

        request.setAttribute("handler", "menu");
    }
}