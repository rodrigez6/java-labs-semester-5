package org.rodrigez.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class BuildingProject extends Project implements Serializable {
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