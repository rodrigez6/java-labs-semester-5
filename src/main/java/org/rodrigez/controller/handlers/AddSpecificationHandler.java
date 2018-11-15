package org.rodrigez.controller.handlers;

import org.rodrigez.model.BuildingProject;
import org.rodrigez.util.Mapping;
import org.rodrigez.validation.BuildingProjectException;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.util.FileTool;
import org.rodrigez.util.FileTool.TypeSave;
import org.rodrigez.validation.BuildingProjectValidator;
import org.rodrigez.validation.Validator;

@Mapping
public class AddSpecificationHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private Validator validator = new BuildingProjectValidator();
    private FileTool fileTool = new FileTool(TypeSave.STRING);

    @Override
    public void execute(Request request) {
        System.out.println("Project will be generated from configuration in file " + fileTool.getFileIn());
        BuildingProject project = (BuildingProject) fileTool.read(BuildingProject.class);

        try {
            validator.validate(project);
            int customerId = Integer.parseInt(request.getAttribute("authorized-id"));
            specificationService.create(project,customerId);
            System.out.println("Specification successfully created");
        } catch (BuildingProjectException e) {
            System.out.println("Error with project configuration: " + e.getMessage());
        }

        request.setAttribute("handler", "menu");
    }
}
