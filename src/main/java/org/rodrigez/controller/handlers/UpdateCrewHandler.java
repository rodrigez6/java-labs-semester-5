package org.rodrigez.controller.handlers;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.view.form.UpdateCrewForm;

public class UpdateCrewHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request){

        new UpdateCrewForm().execute(request);

        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));
        int size = Integer.parseInt(request.getAttribute("size"));
        int designerId = Integer.parseInt(request.getAttribute("authorized-id"));

        if(specificationService.updateCrew(designerId, specificationId, size)){
            System.out.println("Crew updated");
        } else {
            System.out.println("Invalid specification Id");
        }

        request.setAttribute("handler", "menu");
    }
}