package org.rodrigez.model;

import java.io.Serializable;

public class Customer extends Employee implements Serializable {
    public Customer(String name) {
        super(name);
    }
}