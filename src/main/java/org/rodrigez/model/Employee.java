package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class Employee implements Serializable {
    private int id;
    private String name;
    private EmployeePosition position;

    public Employee(String name, EmployeePosition position) {
        this.name = name;
        this.position = position;
    }

    public enum EmployeePosition {
        CUSTOMER, MANAGER, DESIGNER
    }
}