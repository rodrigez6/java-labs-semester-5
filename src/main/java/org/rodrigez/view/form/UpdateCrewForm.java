package org.rodrigez.view.form;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class UpdateCrewForm implements Form {

    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.print(resourceManager.getString("Type_Specification_Id") + ": ");
        int specificationId = scanner.nextInt();
        request.setAttribute("specification-id", String.valueOf(specificationId));
        System.out.print(resourceManager.getString("Type_Crew_Size") + ": ");
        int size = scanner.nextInt();
        request.setAttribute("size", String.valueOf(size));
    }
}
