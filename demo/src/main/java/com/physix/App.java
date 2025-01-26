package com.physix;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.physix.classes.Blocks;
import com.physix.utils.Utility;

public class App {
    // Create the frame
    public static JFrame frame = new JFrame("PhysiX");
    // Create the menu bar
    public static JMenuBar menuBar = new JMenuBar();

    // Create the menus
    public static JMenu menu1 = new JMenu("Files");
    public static JMenu menu2 = new JMenu("Options");
    public static JMenu menu3 = new JMenu("Help");
    // Create menu items for Menu 1
    public static JMenuItem menuItem1_1 = new JMenuItem("New");
    public static JMenuItem menuItem1_2 = new JMenuItem("Save");
    public static JMenuItem menuItem1_3 = new JMenuItem("Open");
    // Create menu items for Menu 2
    // JMenuItem menuItem2_1 = new JMenuItem("Option 1");
    public static JMenuItem menuItem2_2 = new JMenuItem("Run");
    public static JMenuItem menuItem2_3 = new JMenuItem("Run by Step");
    // Create sub-menu for the first item of Menu 2
    public static JMenu subMenu2_1 = new JMenu("Add");
    public static JMenuItem subMenuItem2_1_1 = new JMenuItem("Blocks");
    public static JMenuItem subMenuItem2_1_2 = new JMenuItem("Forces");
    public static JMenuItem subMenuItem2_1_3 = new JMenuItem("Places");

    // Create menu items for Menu 3
    public static JMenuItem menuItem3_1 = new JMenuItem("Settings");
    public static JMenuItem menuItem3_2 = new JMenuItem("Help");
    public static JMenuItem menuItem3_3 = new JMenuItem("About");

    public static void main(String[] args) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        menu1.add(menuItem1_1);
        menu1.add(menuItem1_2);
        menu1.add(menuItem1_3);

        subMenu2_1.add(subMenuItem2_1_1);
        subMenu2_1.add(subMenuItem2_1_2);
        subMenu2_1.add(subMenuItem2_1_3);

        menu2.add(subMenu2_1);
        menu2.add(menuItem2_2);
        menu2.add(menuItem2_3);

        menu3.add(menuItem3_1);
        menu3.add(menuItem3_2);
        menu3.add(menuItem3_3);

        // Add menus to the menu bar
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        // Set the menu bar to the frame
        frame.setJMenuBar(menuBar);

        // Set the frame visibility
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Create a drawing panel
        javax.swing.JPanel drawPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                // Custom drawing code here

                // Example drawing code
             /*   java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
                java.awt.Image img = new javax.swing.ImageIcon("path/to/your/image.png").getImage();
                g2d.drawImage(img, 0, 0, this);*/

            }
        };

        // Add the drawing panel to the frame
        frame.add(drawPanel);
        subMenuItem2_1_1.addActionListener(e -> {
            JFrame popUpFrame = new JFrame("Input Blocks");
            popUpFrame.setSize(300, 200);
            popUpFrame.setLayout(new java.awt.GridLayout(5, 2));

            popUpFrame.add(new javax.swing.JLabel("Input 1:"));
            javax.swing.JTextField input1 = new javax.swing.JTextField();
            popUpFrame.add(input1);

            popUpFrame.add(new javax.swing.JLabel("Input 2:"));
            javax.swing.JTextField input2 = new javax.swing.JTextField();
            popUpFrame.add(input2);

            popUpFrame.add(new javax.swing.JLabel("Input 3:"));
            javax.swing.JTextField input3 = new javax.swing.JTextField();
            popUpFrame.add(input3);

            popUpFrame.add(new javax.swing.JLabel("Input 4:"));
            javax.swing.JTextField input4 = new javax.swing.JTextField();
            popUpFrame.add(input4);

            javax.swing.JButton submitButton = new javax.swing.JButton("Submit");
            popUpFrame.add(submitButton);
            popUpFrame.setLocationRelativeTo(frame);
            submitButton.addActionListener(event -> {
                String input1Text = input1.getText();
                String input2Text = input2.getText();
                String input3Text = input3.getText();
                String input4Text = input4.getText();

                if (input1Text.isEmpty() || input2Text.isEmpty() || input3Text.isEmpty() || input4Text.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(popUpFrame, "All fields must be filled.", "Input Error",
                            javax.swing.JOptionPane.ERROR_MESSAGE);

                    return;
                }

                try {
                    int m = Integer.parseInt(input1Text);
                    int v = Integer.parseInt(input2Text);
                    int f1 = Integer.parseInt(input3Text);
                    int f2 = Integer.parseInt(input4Text);

                    if (m < 0 || v < 0 || f1 < 0 || f2 < 0) {
                        javax.swing.JOptionPane.showMessageDialog(popUpFrame, "Values must be non-negative.",
                                "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);

                        return;
                    }

                    // Handle the input values here
                    popUpFrame.dispose();
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(popUpFrame, "All inputs must be numeric.", "Input Error",
                            javax.swing.JOptionPane.ERROR_MESSAGE);

                }

                // Handle the input values here
                int m = Integer.parseInt(input1.getText());
                int v = Integer.parseInt(input2.getText());
                int f1 = Integer.parseInt(input3.getText());
                int f2 = Integer.parseInt(input4.getText());
                // System.out.println("Mass: " + m);
                // Process the values as needed
                popUpFrame.dispose();
                blk[blksum] = U.newBlock(m, v, f1, f2);
                blk[blksum].print();
                blk[blksum].importPicture();
                moveBlock(blk[blksum].getBlockImage(), drawPanel, drawPanel.getGraphics());
                blksum++;
            });

            popUpFrame.setVisible(true);

        });

        blksum = 0;

    }

    public static Utility U = new Utility();
    public static int blksum;
    public static Blocks[] blk = new Blocks[1000];

    public static void moveBlock(/*Blocks b*/java.awt.Image img, javax.swing.JPanel p, java.awt.Graphics g) {
        // move block
        // Example drawing code
        java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
      //  b.importPicture();
      //  java.awt.Image img = b.getBlockImage();
    p.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
        g2d.clearRect(0, 0, p.getWidth(), p.getHeight());
        for (int i = 0; i < blksum; i++) {
            g2d.drawImage(blk[i].getBlockImage(), blk[i].getX(), blk[i].getY(), p);
        }
        g2d.drawImage(img, e.getX(), e.getY(), p);
        }
    });
    p.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) { // Right-click
            g2d.clearRect(0, 0, p.getWidth(), p.getHeight());
            for (int i = 0; i < blksum; i++) {
            g2d.drawImage(blk[i].getBlockImage(), blk[i].getX(), blk[i].getY(), p);
            }
            g2d.drawImage(img, e.getX(), e.getY(), p);
            p.removeMouseMotionListener(p.getMouseMotionListeners()[0]);
            p.removeMouseListener(p.getMouseListeners()[0]);
        }
        }
    });
      /*/  p.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
            g2d.clearRect(0, 0, p.getWidth(), p.getHeight());
            g2d.drawImage(img, e.getX(), e.getY(), p);
            }
        });
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) { // Right-click
                g2d.clearRect(0, 0, p.getWidth(), p.getHeight());
                g2d.drawImage(img, e.getX(), e.getY(), p);
                p.removeMouseMotionListener(p.getMouseMotionListeners()[0]);
                p.removeMouseListener(p.getMouseListeners()[0]);
            }
            }
        });*/
        //g2d.drawImage(img, 0, 0, p);
    }
}