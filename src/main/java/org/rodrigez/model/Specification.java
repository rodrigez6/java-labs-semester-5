package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Specification {
    private int id;
    private Project project;
    private Employee customer;
    private Employee manager;
    private Employee designer;
    private int cost;
    private DesignersCrew designersCrew;
    private boolean registered;

    public Specification(){}

    @Override
    public String toString() {
        return String.format("|%-10d|", id) +
                String.format("|%-80s|", project.description) +
                String.format("|%-20s|", customer==null?"":customer.getName()) +
                String.format("|%-20s|", manager==null?"":manager.getName()) +
                String.format("|%-20s|", designer==null?"":designer.getName()) +
                String.format("|%-10d|", cost) +
                String.format("|%-10s|", designersCrew==null?"":designersCrew.getCrewSize());
    }

    public static String header(){
        return String.format("|%-10s|", "Id") +
                String.format("|%-80s|", "Description") +
                String.format("|%-20s|", "Customer") +
                String.format("|%-20s|", "Manager") +
                String.format("|%-20s|", "Designer") +
                String.format("|%-10s|", "Cost") +
                String.format("|%-10s|", "Crew");
    }
}