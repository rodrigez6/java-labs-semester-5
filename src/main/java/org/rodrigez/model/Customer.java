package org.rodrigez.model;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    public Customer(String name) {
        super(name);
    }
}