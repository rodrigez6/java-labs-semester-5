package org.rodrigez.commands;

import org.rodrigez.model.BuildingProject;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.BeanStorage;
import org.rodrigez.routing.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.validation.forms.BuildingProjectForm;
import org.rodrigez.view.View;

public class CreateSpecificationHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);

    @Override
    public void execute(Request request){
        request.setAttribute("floors-number","1");
        request.setAttribute("housing-class","2");
        request.setAttribute("address","tarasa");

        BuildingProjectForm form = new BuildingProjectForm(
                request.getAttribute("floors-number"),
                request.getAttribute("housing-class"),
                request.getAttribute("address")
        );

        BuildingProject project = form.parseForm();

        if(project.getFloorsNumber()<=0){
            String alert = "Floors number must be more than 0";
            request.setAttribute("alert",alert);
            return;
        }
        if(project.getHousingClass()<=0||project.getHousingClass()>3){
            String alert = "Housing class must be from 1 to 3";
            request.setAttribute("alert",alert);
            return;
        }

        Specification specification = specificationService.create(project);
        String alert = "Specification created: " + specification;
        request.setAttribute("alert",alert);

    }
}