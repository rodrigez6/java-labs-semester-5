package org.rodrigez.model;

import java.util.ArrayList;

public class DesignersCrew {
    private ArrayList<Designer> designers;

    public DesignersCrew(int numberOfDesigners) {
        designers = new ArrayList<>(numberOfDesigners);
    }

    public ArrayList<Designer> getDesigners() {
        return designers;
    }

    public void setDesigners(ArrayList<Designer> designers) {
        this.designers = designers;
    }
}