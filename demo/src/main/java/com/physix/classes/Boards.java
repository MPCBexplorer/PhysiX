package com.physix.classes;

import java.util.HashMap;
import java.util.Map;

public class Boards extends Blocks{
    public Boards(double a, Vectors b, Vectors c, Vectors d, double w,double h,String name) {
        super(a, b, c, d, name);
        this.width = w;
        this.height = h;
    }
    private double width;
    private double height;
    public void setWidth(double a) {
        this.width = a;
    }
    public void setHeight(double a) {
        this.height = a;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }
    private final Map<Blocks, Double> U = new HashMap<>();
    public void setU(Blocks a, double b) {
        this.U.put(a, b);
    }
    public double getU(Blocks a) {
        return this.U.get(a);
    }
}
