/**
 * The Blocks class represents a physical block with properties such as mass, velocity,
 * acceleration, and jerk. It also includes methods to manipulate and retrieve these properties,
 * as well as methods to handle the block's placement and image representation.
 *
 * <p>
 * This class provides the following functionalities:
 * <ul>
 * <li>Set and get the name of the block</li>
 * <li>Set and get the placement status of the block</li>
 * <li>Set and get the x and y coordinates of the block</li>
 * <li>Import and retrieve the block's image</li>
 * <li>Set and get the mass, velocity, acceleration, and jerk of the block</li>
 * <li>Print the block's properties</li>
 * </ul>
 *
 * <p>
 * Note: The snap property and related methods are commented out and not
 * currently in use.
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * Blocks block = new Blocks(10, 5, 2, 1, "MyBlock");
 * block.setX(100);
 * block.setY(200);
 * block.setIsPlaced(true);
 * block.print();
 * }
 * </pre>
 *
 * @author MPCBexplorer
 * @version 1.0.0AlphaSnapshot
 */
package com.physix.classes;

public class Blocks {

    double mass;// kg
    Vectors velocity;// m/s
    Vectors acceleration;// m/s^2
    Vectors jerk;// m/s^3
    // double snap;//m/s^4
    double x = 0;
    double y = 0;
    boolean IsPlaced = false;
    String name = "Block";

    public void setName(String a) {
        this.name = a;
    }

    public String getName() {
        return this.name;
    }

    public void setIsPlaced(boolean a) {
        this.IsPlaced = a;
    }

    public boolean getIsPlaced() {
        return this.IsPlaced;
    }

    public void setX(double a) {
        this.x = a;
    }

    public void setY(double a) {
        this.y = a;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    // Method to import picture block.png
    private void importPicture() {
        try {
            java.awt.image.BufferedImage image = javax.imageio.ImageIO
                    .read(new java.io.File("demo\\src\\main\\resources\\block.png"));
            blockImage = image;
            System.out.println("Picture imported successfully.");
            // addRightClickMenu(blockImage);
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

    public Blocks(double mass, Vectors velocity, Vectors acceleration, Vectors jerk/* , double snap */, String s) {
        this.mass = mass;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.jerk = jerk;
        // this.snap = snap;
        this.IsPlaced = false;
        this.name = s;
        this.importPicture();
    }

    public double getMass() {
        return mass;
    }

    public Vectors getVelocity() {
        return velocity;
    }

    public Vectors getAcceleration() {
        return acceleration;
    }

    public Vectors getJerk() {
        return jerk;
    }

    /*
     * public Vectors getSnap(){
     * return snap;
     * }
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setVelocity(Vectors velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(Vectors acceleration) {
        this.acceleration = acceleration;
    }

    public void setJerk(Vectors jerk) {
        this.jerk = jerk;
    }

    /*
     * public void setSnap(Vectors snap){
     * this.snap = snap;
     * }
     */
    public void print() {
        System.out.println("Mass: " + mass + " kg");
        System.out.println("Velocity: " + velocity + " m/s");
        System.out.println("Acceleration: " + acceleration + " m/s^2");
        System.out.println("Jerk: " + jerk + " m/s^3");
        // System.out.println("Snap: " + snap + " m/s^4");
    }

    public void move() {
        double vx = velocity.getX() * Math.cos(Math.toRadians(velocity.getAngle()))
                + acceleration.getX() * Math.cos(Math.toRadians(acceleration.getAngle())) * 0.04;
        double vy = velocity.getX() * Math.sin(Math.toRadians(velocity.getAngle()))
                + acceleration.getX() * Math.sin(Math.toRadians(acceleration.getAngle())) * 0.04;

        if (vx == 0) {
            if (vy > 0) {
                velocity.setAngle(90);
            } else {
                velocity.setAngle(-90);
            }
        } else {
            velocity.setAngle(Math.toDegrees(Math.atan(vy / vx)));
            if (vx < 0) {
                velocity.setAngle(180 + velocity.getAngle());
            }
        }

        velocity.setX(
                Math.sqrt(
                        Math.pow(vx, 2)
                        + Math.pow(vy, 2)));
        this.x += velocity.getX() * Math.cos(Math.toRadians(velocity.getAngle())) * 0.04 * 25;
        //In the frame, the y-axis is inverted
        this.y -= velocity.getX() * Math.sin(Math.toRadians(velocity.getAngle())) * 0.04 * 25;
        System.out.println("vangle: " + velocity.getAngle() + " aangle: " + acceleration.getAngle());
    }
}
