package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public abstract class Employee {
    private String name;
    private int id;

    public Employee(String name) {
        this.name = name;
    }
}