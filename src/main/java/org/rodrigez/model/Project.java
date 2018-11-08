package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public abstract class Project {
    private int id;
    protected String description;
}