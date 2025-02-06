package com.physix.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import com.physix.classes.Blocks;
import com.physix.classes.Vectors;

public class Utility {
    public static Blocks newBlock(double a, Vectors b, Vectors c, Vectors d,String name) {
        System.out.println("New Block of");
        Blocks blk0 = new Blocks(a, b, c, d, name);
        blk0.setIsPlaced(true);
        return blk0;
    }

    public static void rePaint(ArrayList<Blocks> blk, java.awt.Graphics2D g2d, javax.swing.JPanel p) {
        //g2d.clearRect(0, 0, p.getWidth(), p.getHeight());
        try{
            BufferedImage background = javax.imageio.ImageIO.read(Utility.class.getClassLoader().getResourceAsStream("background.png"));
        g2d.drawImage(background, 0, 0, p.getWidth(), p.getHeight(), null);
        for (Blocks blocks : blk) {
            if (blocks.getIsPlaced()) {
                g2d.drawImage(blocks.getBlockImage(), (int)blocks.getX() - 12, (int)blocks.getY() - 25, p);
            }
        }
        }catch(IOException e){
            System.out.println("Background image not found");
        }

    }

    public static void saveFrame(ArrayList<Blocks> blk, java.awt.Graphics2D g2d, javax.swing.JPanel p){
        //g2d.clearRect(0, 0, p.getWidth(), p.getHeight());
        try{
            BufferedImage background = javax.imageio.ImageIO.read(Utility.class.getClassLoader().getResourceAsStream("background.png"));
        g2d.drawImage(background, 0, 0, p.getWidth(), p.getHeight(), null);
        for (Blocks blocks : blk) {
            if (blocks.getIsPlaced()) {
                g2d.drawImage(blocks.getBlockImage(), (int)blocks.getX() - 12, (int)blocks.getY() - 25,null);
            }
        }
        }catch(IOException e){
            p.repaint();
            System.out.println("Background image not found");
        }
    }

}
