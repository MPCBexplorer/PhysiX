package com.physix.utils;

import java.util.ArrayList;

import com.physix.classes.Blocks;

public class Utility {
    public Blocks newBlock(int a, int b, int c, int d,String name) {
        System.out.println("New Block of");
        Blocks blk0 = new Blocks(a, b, c, d, name);
        blk0.setIsPlaaced(true);
        return blk0;
    }

    public static void rePaint(ArrayList<Blocks> blk, int blksum, java.awt.Graphics2D g2d, javax.swing.JPanel p) {
        g2d.clearRect(0, 0, p.getWidth(), p.getHeight());
        for (Blocks blocks : blk) {
            if (blocks.getIsPlaced() == true) {
                g2d.drawImage(blocks.getBlockImage(), blocks.getX() - 14, blocks.getY() - 27, p);
            }
        }
    }
}
