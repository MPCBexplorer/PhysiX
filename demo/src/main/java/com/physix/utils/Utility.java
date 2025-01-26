package com.physix.utils;

import com.physix.classes.Blocks;


public class Utility {
    public Blocks newBlock(int a,int b,int c,int d){ 
        System.out.println("New Block of");
        Blocks blk0=new Blocks(a, b, c, d);
        return blk0;
    }
}
