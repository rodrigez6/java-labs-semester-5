package org.rodrigez.view;

import java.util.Scanner;

public class ConsoleView implements View {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void print(Object o) {
        System.out.print(o);
    }

    @Override
    public String read(String attribute) {
        System.out.print(attribute);
        return scanner.next();
    }
}