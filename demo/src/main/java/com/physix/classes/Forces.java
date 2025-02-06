package com.physix.classes;

public class Forces {
    private double force;
    private double angle;
    private String name;
    private Blocks object;
    public Forces(double force, double angle, String name, Blocks object) {
        this.force = force;
        this.angle = angle;
        this.name = name;
        this.object = object;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blocks getObject() {
        return object;
    }

    public void setObject(Blocks object) {
        this.object = object;
    }
}
