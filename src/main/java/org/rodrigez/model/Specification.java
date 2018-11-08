package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Specification {
    private int id;
    private Project project;
    private Customer customer;
    private Manager manager;
    private Designer designer;
    private int cost;
    private DesignersCrew designersCrew;
    private boolean provided;
    private boolean registered;

    public Specification(){}

    public Specification(Project project) {
        this.project = project;
    }
}