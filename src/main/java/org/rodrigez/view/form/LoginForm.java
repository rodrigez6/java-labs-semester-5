package org.rodrigez.view.form;

import org.rodrigez.util.Request;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class LoginForm implements Form {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {

        System.out.print("For login type your id: ");
        int loginId = Integer.parseInt(scanner.next());
        request.setAttribute("login-id", String.valueOf(loginId));
    }
}
