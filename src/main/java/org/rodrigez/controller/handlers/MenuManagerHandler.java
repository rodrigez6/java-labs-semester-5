package org.rodrigez.controller.handlers;

import org.rodrigez.util.Request;

import java.util.Scanner;

public class MenuManagerHandler extends Handler {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void execute(Request request) {
        System.out.print("1.My specifications 2.Register specifications 3.Save specification 4.Log out\n");
        System.out.print("Type number: ");
        int c = scanner.nextInt();
        switch (c){
            case 1: {
                request.setAttribute("handler","get-manager-specifications");
                break;
            }
            case 2: {
                request.setAttribute("handler","register-specifications");
                break;
            }
            case 3: {
                request.setAttribute("handler","save-specification");
                break;
            }
            case 4: {
                request.setAttribute("handler","logout");
                break;
            }
        }
    }
}
