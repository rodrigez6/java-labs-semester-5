package org.rodrigez.view;

import java.util.Scanner;

public class ConsoleView implements View {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public int scanInt() {
        return scanner.nextInt();
    }

    @Override
    public String scanString() {
        return scanner.next();
    }
}