package org.rodrigez.controller.handlers;

import org.rodrigez.model.Specification;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.util.FileTool;
import org.rodrigez.util.FileTool.TypeSave;
import org.rodrigez.view.form.SaveSpecificationForm;

public class SaveSpecificationHandler extends Handler {

    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private FileTool fileTool = new FileTool(TypeSave.JSON);

    @Override
    public void execute(Request request) {

        new SaveSpecificationForm().execute(request);

        int specificationId = Integer.parseInt(request.getAttribute("specification-id"));

        Specification specification = specificationService.findById(specificationId);

        if(specification==null){
            System.out.println("Invalid specification id");
        } else{
            System.out.println("Specification will be saved in file " + fileTool.getFileOut());
            fileTool.write(specification);
        }

        request.setAttribute("handler","menu");
    }
}