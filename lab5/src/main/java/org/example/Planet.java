package org.example;

public class Planet {
    private String name;
    private double diameter;
    private double distanceFromSun;

    public Planet(String name, double diameter, double distanceFromSun) {
        this.name = name;
        this.diameter = diameter;
        this.distanceFromSun = distanceFromSun;
    }

    public String getName() {
        return name;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistanceFromSun(double distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }
}
