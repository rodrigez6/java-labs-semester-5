package org.rodrigez.controller.handlers;

import org.rodrigez.model.BuildingProject;
import org.rodrigez.validation.BuildingProjectException;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.util.FileTool;
import org.rodrigez.util.FileTool.TypeSave;
import org.rodrigez.validation.BuildingProjectValidator;
import org.rodrigez.validation.Validator;

import org.apache.log4j.Logger;

public class AddSpecificationHandler extends Handler {

    final static Logger logger = Logger.getLogger(AddSpecificationHandler.class);

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private Validator validator = new BuildingProjectValidator();
    private FileTool fileTool = new FileTool(TypeSave.STRING);

    @Override
    public void execute(Request request) {

        BuildingProject project = (BuildingProject) fileTool.read(BuildingProject.class);
        logger.info("Project generated from configuration in file " + fileTool.getFileIn());

        try {
            validator.validate(project);

            int customerId = Integer.parseInt(request.getAttribute("authorized-id"));

            specificationService.create(project,customerId);

//            String message = "Specification created";
//            request.setAttribute("message", message);
        } catch (BuildingProjectException e) {
//            logger.info("Error with project configuration: " + e.getMessage());
//            System.out.println("Error with project configuration: " + e.getMessage());
        }

        request.setAttribute("handler", "menu");
    }
}