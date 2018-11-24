package org.rodrigez.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Specification {

    private int id;
    private Project project;
    private Employee customer;
    private Employee manager;
    private Employee designer;
    private int cost;
    private DesignersCrew designersCrew;
    private boolean registered;
}