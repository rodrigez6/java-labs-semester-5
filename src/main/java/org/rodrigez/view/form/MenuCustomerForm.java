package org.rodrigez.view.form;

import org.rodrigez.util.Request;
import org.rodrigez.view.Form;

import java.util.Scanner;

public class MenuCustomerForm implements Form {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Request request) {
        System.out.print("1.My specifications 2.Add specification 3. Save specification 4.Log out\n");
        System.out.print("Type number: ");
        int c = scanner.nextInt();
        request.setAttribute("menu-choice", String.valueOf(c));
    }
}
