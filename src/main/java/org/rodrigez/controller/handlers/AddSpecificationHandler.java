package org.rodrigez.controller.handlers;

import org.apache.log4j.Logger;
import org.rodrigez.model.BuildingProject;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.service.exception.NotFoundException;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.FileTool;
import org.rodrigez.util.FileTool.TypeSave;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.validation.ValidationException;
import org.rodrigez.validation.Validator;
import org.rodrigez.validation.validator.BuildingProjectValidator;
import org.rodrigez.view.page.MessagePage;

import java.io.IOException;

public class AddSpecificationHandler implements Handler {

    private final static Logger logger = Logger.getLogger(AddSpecificationHandler.class);

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);
    private Validator validator = new BuildingProjectValidator();
    private FileTool fileTool = new FileTool(TypeSave.STRING);

    @Override
    public void execute(Request request) {

        BuildingProject project;
        try {
            project = (BuildingProject) fileTool.read(BuildingProject.class);
            logger.info("Project generated from configuration in file " + fileTool.getFileIn());
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e.getMessage());
            return;
        }

        try {
            validator.validate(project);
        } catch (ValidationException e) {
            logger.error(e.getMessage());
            return;
        }

        int authorizedId = Integer.parseInt(request.getAttribute("authorized-id"));

        String message;
        try {
            specificationService.create(project,authorizedId);
            message = resourceManager.getString("OK");
        } catch (NotFoundException e) {
            message = resourceManager.getString("Auth_Error");
            logger.error(e.getMessage());
        }

        new MessagePage().show(message);

        request.setAttribute("handler", "menu");
    }

}