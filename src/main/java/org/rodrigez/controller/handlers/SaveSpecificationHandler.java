package org.rodrigez.controller.handlers;

import org.apache.log4j.Logger;
import org.rodrigez.model.Specification;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.util.FileTool;
import org.rodrigez.util.FileTool.TypeSave;
import org.rodrigez.validation.NotFoundException;
import org.rodrigez.view.form.SaveSpecificationForm;
import org.rodrigez.view.page.MessagePage;

import java.io.IOException;

public class SaveSpecificationHandler extends Handler {

    private final static Logger logger = Logger.getLogger(AddSpecificationHandler.class);
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private FileTool fileTool = new FileTool(TypeSave.JSON);

    @Override
    public void execute(Request request) {

        new SaveSpecificationForm().execute(request);

        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));

        String message;
        try {
            Specification specification = specificationService.findById(specificationId);
            fileTool.write(specification);
            message = "Operation is successful";
            logger.info("Specification saved in file " + fileTool.getFileOut());
        } catch (NotFoundException e) {
            message = e.getMessage();
        } catch (IllegalAccessException | IOException e) {
            message = e.getMessage();
            logger.error(e.getMessage());
        }

        new MessagePage().show(message);

        request.setAttribute("handler","menu");
    }
}