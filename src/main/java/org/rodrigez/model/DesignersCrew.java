package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter @Getter
public class DesignersCrew {
    private ArrayList<Designer> designers;

    public DesignersCrew(int numberOfDesigners) {
        designers = new ArrayList<>(numberOfDesigners);
    }
}