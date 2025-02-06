package com.physix.classes;

public class Vectors {
    private double  x;
    private double angle;
    public Vectors(double x, double  angle) {
        this.x = x;
        this.angle = angle;
    }
    public double  getX() {
        return x;
    }
    public void setX(double  x) {
        this.x = x;
    }
    public double  getAngle() {
        return angle;
    }
    public void setAngle(double  angle) {
        this.angle = angle;
    }
}
