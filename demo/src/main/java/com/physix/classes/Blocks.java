package com.physix.classes;


public class Blocks {
    int mass;//kg
    int velocity;//m/s
    int acceleration;//m/s^2
    int jerk;//m/s^3
    //int snap;//m/s^4
    int x=0;
    int y=0;
    public void setX(int a){
        this.x=a;
    }
    public void setY(int a){
        this.y=a;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    // Method to import picture block.png
    public void importPicture() {
         try {
            java.awt.image.BufferedImage image = javax.imageio.ImageIO.read(new java.io.File("demo\\src\\main\\resources\\block.png"));
            blockImage=image;
            System.out.println("Picture imported successfully.");
         } catch (java.io.IOException e) {
             System.out.println("Error importing picture: " + e.getMessage());
         }
    }

    private java.awt.image.BufferedImage blockImage;

    public java.awt.image.BufferedImage getBlockImage() {
        return blockImage;
    }

    public void setBlockImage(java.awt.image.BufferedImage blockImage) {
        this.blockImage = blockImage;
    }

    public Blocks(int mass, int velocity, int acceleration, int jerk/*, int snap*/){
        this.mass = mass;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.jerk = jerk;
        //this.snap = snap;
    }
    public int getMass(){
        return mass;
    }
    public int getVelocity(){
        return velocity;
    }
    public int getAcceleration(){
        return acceleration;
    }
    public int getJerk(){
        return jerk;
    }
    /*public int getSnap(){
        return snap;
    }*/
    public void setMass(int mass){
        this.mass = mass;
    }
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
    public void setAcceleration(int acceleration){
        this.acceleration = acceleration;
    }
    public void setJerk(int jerk){
        this.jerk = jerk;
    }
    /*public void setSnap(int snap){
        this.snap = snap;
    }*/
    public void print(){
        System.out.println("Mass: " + mass + " kg");
        System.out.println("Velocity: " + velocity + " m/s");
        System.out.println("Acceleration: " + acceleration + " m/s^2");
        System.out.println("Jerk: " + jerk + " m/s^3");
      //  System.out.println("Snap: " + snap + " m/s^4");
    }

}
