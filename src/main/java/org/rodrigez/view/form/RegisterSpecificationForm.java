package org.rodrigez.view.form;

import org.rodrigez.util.Request;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class RegisterSpecificationForm implements Form {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.print("Type designer id: ");
        int designerId = scanner.nextInt();
        request.setAttribute("designer-id", String.valueOf(designerId));
    }
}
