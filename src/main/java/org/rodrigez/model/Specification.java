package org.rodrigez.model;

public class Specification {
    private Project project;
    private Customer customer;
    private Manager manager;
    private double cost;
    private DesignersCrew designersCrew;

    public DesignersCrew getDesignersCrew() {
        return designersCrew;
    }

    public void setDesignersCrew(DesignersCrew designersCrew) {
        this.designersCrew = designersCrew;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Specification(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}