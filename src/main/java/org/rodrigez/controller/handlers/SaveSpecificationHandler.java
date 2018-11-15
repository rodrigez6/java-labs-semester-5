package org.rodrigez.controller.handlers;

import org.rodrigez.model.Specification;
import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.service.SpecificationService;
import org.rodrigez.util.FileTool;
import org.rodrigez.util.FileTool.TypeSave;

import java.util.Scanner;

public class SaveSpecificationHandler extends Handler {
    private SpecificationService specificationService = BeanStorage.INSTANCE.get(SpecificationService.class);
    private Scanner scanner = new Scanner(System.in);
    private FileTool fileTool = new FileTool(TypeSave.JSON);

    @Override
    public void execute(Request request) {
        System.out.print("Type specification id: ");
        int specificationId = scanner.nextInt();
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
