package org.rodrigez.view.form;

import org.rodrigez.util.Request;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class SaveSpecificationForm implements Form {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.print("Type specification id: ");
        int specificationId = scanner.nextInt();
        request.setAttribute("specification-id", String.valueOf(specificationId));
    }
}
