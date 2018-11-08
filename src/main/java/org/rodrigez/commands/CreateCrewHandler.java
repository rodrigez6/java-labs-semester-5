package org.rodrigez.commands;

import org.rodrigez.routing.BeanStorage;
import org.rodrigez.routing.Request;
import org.rodrigez.service.SpecificationService;

public class CreateCrewHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    @Override
    public void execute(Request request){
        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));
        specificationService.updateCrew(specificationId);
        String alert = "Crew created";
        request.setAttribute("alert", alert);
    }
}