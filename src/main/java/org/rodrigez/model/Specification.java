package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Specification {
    private Project project;
    private Customer customer;
    private Manager manager;
    private double cost;
    private DesignersCrew designersCrew;

    public Specification(Project project) {
        this.project = project;
    }
}