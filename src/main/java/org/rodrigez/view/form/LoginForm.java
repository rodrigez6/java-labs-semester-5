package org.rodrigez.view.form;

import org.rodrigez.util.BeanStorage;
import org.rodrigez.util.Request;
import org.rodrigez.util.ResourceManager;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class LoginForm implements Form {

    private ResourceManager resourceManager = BeanStorage.INSTANCE.get(ResourceManager.class);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {

        System.out.print(resourceManager.getString("Type_Your_Id") + ": ");
        int loginId = Integer.parseInt(scanner.next());
        request.setAttribute("login-id", String.valueOf(loginId));
    }
}
