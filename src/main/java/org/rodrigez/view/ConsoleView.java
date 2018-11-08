package org.rodrigez.view;

import org.rodrigez.model.*;

import java.util.Scanner;

public class ConsoleView implements View {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void write(Object o) {
        System.out.print(o);
    }

    @Override
    public Object read(Class aClass) {
        System.out.println("Enter " + aClass.getSimpleName() + " params");
        if(aClass.equals(Manager.class)){
            return readManager();
        } else if(aClass.equals(Customer.class)){
            return readCustomer();
        } else if(aClass.equals(Designer.class)){
            return readDesigner();
        } else if(aClass.equals(BuildingProject.class)){
                return readBuildingProject();
        } else {
            return null;
        }
    }

    private Designer readDesigner() {
        System.out.print("Name: ");
        String name = scanner.next();
        return new Designer(name);
    }

    private Customer readCustomer() {
        System.out.print("Name: ");
        String name = scanner.next();
        return new Customer(name);
    }

    private Manager readManager(){
        System.out.print("Name: ");
        String name = scanner.next();
        return new Manager(name);
    }

    private BuildingProject readBuildingProject() {
        System.out.print("Floors number: ");
        int floorsNumber = scanner.nextInt();
        System.out.print("Housing class: ");
        int housingClass = scanner.nextInt();
        System.out.print("Address: ");
        String address = scanner.next();
        return new BuildingProject(floorsNumber,housingClass,address);
    }
}