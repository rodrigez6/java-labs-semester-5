package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BuildingProject extends Project{
    private int floorsNumber;
    private int housingClass;
    private String address;

    public BuildingProject(int floorsNumber, int housingClass, String address) {
        this.floorsNumber = floorsNumber;
        this.housingClass = housingClass;
        this.address = address;
        this.description = "Building is based on " + address + ", floors number = " + floorsNumber + ", housing class = " + housingClass;
    }

        @Override
    public String toString() {
        return description;
    }

}