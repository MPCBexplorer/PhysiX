package com.physix.classes;

import java.util.HashMap;
import java.util.Map;

public class Faces {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    public Faces(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    public int getStartX() {
        return startX;
    }
    public void setStartX(int startX) {
        this.startX = startX;
    }
    public int getStartY() {
        return startY;
    }
    public void setStartY(int startY) {
        this.startY = startY;
    }
    public int getEndX() {
        return endX;
    }
    public void setEndX(int endX) {
        this.endX = endX;
    }
    public int getEndY() {
        return endY;
    }
    public void setEndY(int endY) {
        this.endY = endY;
    }
    public void print() {
        System.out.println("Face from (" + this.startX + "," + this.startY + ") to (" + this.endX + "," + this.endY + ")");
    }
    private final Map<Blocks, Double> U = new HashMap<>();
    public void setU(Blocks a, double b) {
        this.U.put(a, b);
    }
    public double getU(Blocks a) {
        return this.U.get(a);
    }
}
