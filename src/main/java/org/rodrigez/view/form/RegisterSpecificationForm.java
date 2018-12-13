package org.rodrigez.view.form;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class RegisterSpecificationForm implements Form {

    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.print(resourceManager.getString("Type_Designer_Id") + ": ");
        int designerId = scanner.nextInt();
        request.setAttribute("designer-id", String.valueOf(designerId));
    }
}
