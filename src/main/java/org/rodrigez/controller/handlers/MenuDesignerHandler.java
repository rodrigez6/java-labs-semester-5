package org.rodrigez.controller.handlers;

import org.rodrigez.util.Request;

import java.util.Scanner;

public class MenuDesignerHandler extends Handler {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void execute(Request request) {
        System.out.print("1.My specifications 2.Bill cost 3.Set crew size 4.Save specification 5.Log out\n");
        System.out.print("Type number: ");
        int c = scanner.nextInt();
        switch (c){
            case 1: {
                request.setAttribute("handler","get-designer-specifications");
                break;
            }
            case 2: {
                request.setAttribute("handler","bill-cost");
                break;
            }
            case 3: {
                request.setAttribute("handler","create-crew");
                break;
            }
            case 4: {
                request.setAttribute("handler","save-specification");
                break;
            }
            case 5: {
                request.setAttribute("handler","logout");
                break;
            }
        }
    }
}