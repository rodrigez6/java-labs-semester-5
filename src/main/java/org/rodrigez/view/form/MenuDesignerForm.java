package org.rodrigez.view.form;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class MenuDesignerForm implements Form {

    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.println(resourceManager.getString("Menu_Designer"));
        System.out.print(resourceManager.getString("Type_Number") + ": ");
        int c = scanner.nextInt();
        request.setAttribute("menu-choice", String.valueOf(c));
    }
}
