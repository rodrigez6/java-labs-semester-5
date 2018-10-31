package org.rodrigez.model;

public class BuildingProject extends Project{
    private int floorsNumber;
    private int housingClass;
    private String address;

    public BuildingProject(int floorsNumber, int housingClass, String address) {
        this.floorsNumber = floorsNumber;
        this.housingClass = housingClass;
        this.address = address;
        this.description = "BuildingProject is based on " + address + ", floorsNumber = " + floorsNumber + ", housingClass=" + housingClass;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public int getHousingClass() {
        return housingClass;
    }

    public void setHousingClass(int housingClass) {
        this.housingClass = housingClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return description;
    }
}