package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class Employee implements Serializable {
    private int id;
    private String name;
    private Role role;

    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public Employee() {
    }
}