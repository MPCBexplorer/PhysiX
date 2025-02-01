package com.physix;

import java.util.ArrayList;

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
    public static JMenu menu2x = new JMenu("Edit");
    // Create menu items for Menu 1
    public static JMenuItem menuItem1_1 = new JMenuItem("New");
    public static JMenuItem menuItem1_2 = new JMenuItem("Save");
    public static JMenuItem menuItem1_3 = new JMenuItem("Open");
    // Create menu items for Menu 2x
    public static JMenuItem menuItem2x_1 = new JMenuItem("Show Edit Frame");
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

        menu2x.add(menuItem2x_1);

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
        menuBar.add(menu2x);
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

            }
        };
       
        // Add the drawing panel to the frame
        frame.add(drawPanel);
        menuItem2x_1.addActionListener(e -> {
            JFrame popUpFrame = new JFrame("Edit Items");
            popUpFrame.setSize(300, 500);
            javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();

            javax.swing.JPanel tab1 = new javax.swing.JPanel();
            javax.swing.JPanel tab2 = new javax.swing.JPanel();

            javax.swing.JButton button1 = new javax.swing.JButton("New");
            javax.swing.JButton button2 = new javax.swing.JButton("Edit");
            button2.setEnabled(false);
            javax.swing.JButton button3 = new javax.swing.JButton("Delete");
            button3.setEnabled(false);
            javax.swing.DefaultListModel<String> listModel = new javax.swing.DefaultListModel<>();
            for (Blocks block : blk) {
                listModel.addElement(block.getName());
            }
           javax.swing.JList<String> list = new javax.swing.JList<>(listModel);
            listModel.addListDataListener(new javax.swing.event.ListDataListener() {
                @Override
                public void intervalAdded(javax.swing.event.ListDataEvent e) {
                    list.updateUI();
                }

                @Override
                public void intervalRemoved(javax.swing.event.ListDataEvent e) {
                    list.updateUI();
                }

                @Override
                public void contentsChanged(javax.swing.event.ListDataEvent e) {
                    list.updateUI();
                }
            });
            button2.addActionListener(e2 -> {
                int selectedIndex = list.getSelectedIndex();
                Blocks selectedBlock = blk.get(selectedIndex);
                JFrame popUpFrame2 = new JFrame("Edit Block");
                popUpFrame2.setSize(300, 200);
                popUpFrame2.setLayout(new java.awt.GridLayout(6, 2));

                popUpFrame2.add(new javax.swing.JLabel("Mass:"));
                javax.swing.JTextField input1 = new javax.swing.JTextField();
                input1.setText(String.valueOf(selectedBlock.getMass()));
                popUpFrame2.add(input1);

                popUpFrame2.add(new javax.swing.JLabel("Velocity:"));
                javax.swing.JTextField input2 = new javax.swing.JTextField();
                input2.setText(String.valueOf(selectedBlock.getVelocity()));
                popUpFrame2.add(input2);

                popUpFrame2.add(new javax.swing.JLabel("Acceleration:"));
                javax.swing.JTextField input3 = new javax.swing.JTextField();
                input3.setText(String.valueOf(selectedBlock.getAcceleration()));
                popUpFrame2.add(input3);

                popUpFrame2.add(new javax.swing.JLabel("Jerk:"));
                javax.swing.JTextField input4 = new javax.swing.JTextField();
                input4.setText(String.valueOf(selectedBlock.getJerk()));
                popUpFrame2.add(input4);

                popUpFrame2.add(new javax.swing.JLabel("Name:"));
                javax.swing.JTextField input5 = new javax.swing.JTextField();
                input5.setText(selectedBlock.getName());
                popUpFrame2.add(input5);

                javax.swing.JButton submitButton = new javax.swing.JButton("Submit");
                popUpFrame2.add(submitButton);
                popUpFrame2.setLocationRelativeTo(frame);
                submitButton.addActionListener(event -> {
                    String input1Text = input1.getText();
                    String input2Text = input2.getText();
                    String input3Text = input3.getText();
                    String input4Text = input4.getText();

                    if (input1Text.isEmpty() || input2Text.isEmpty() || input3Text.isEmpty() || input4Text.isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(popUpFrame, "All fields must be filled.",
                                "Input Error",
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
                        popUpFrame2.dispose();
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(popUpFrame, "All inputs must be numeric.",
                                "Input Error",
                                javax.swing.JOptionPane.ERROR_MESSAGE);

                    }

                    // Handle the input values here
                    int m = Integer.parseInt(input1.getText());
                    int v = Integer.parseInt(input2.getText());
                    int f1 = Integer.parseInt(input3.getText());
                    int f2 = Integer.parseInt(input4.getText());
                    // System.out.println("Mass: " + m);
                    // Process the values as needed
                    popUpFrame2.dispose();
                    Blocks newBlock = U.newBlock(m, v, f1, f2, blk.get(selectedIndex).getName());
                    moveBlock(newBlock, drawPanel, drawPanel.getGraphics());
                    blk.set(selectedIndex, newBlock);
                    listModel.set(selectedIndex, newBlock.getName());

                    Utility.rePaint(blk, blk.size(), (java.awt.Graphics2D) drawPanel.getGraphics(), drawPanel);
                });
                popUpFrame2.setLocationRelativeTo(frame);
                popUpFrame2.setVisible(true);
            });
            button3.addActionListener(e2 -> {
                    int confirm = javax.swing.JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this block?", "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION);
                    if (confirm != javax.swing.JOptionPane.YES_OPTION) {
                        return;
                    }
                    int selectedIndex = list.getSelectedIndex();
                    blk.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                    Utility.rePaint(blk, blk.size(), (java.awt.Graphics2D) drawPanel.getGraphics(), drawPanel);
                });
            list.addListSelectionListener(e1 -> {
                boolean isSelection = !list.isSelectionEmpty();
                button2.setEnabled(true);
                button3.setEnabled(true);
                if (isSelection) {
                    int selectedIndex = list.getSelectedIndex();
                    Blocks selectedBlock = blk.get(selectedIndex);
                    selectedBlock.print();
                }
                
            });
            tab1.setLayout(new java.awt.BorderLayout());

            javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
            buttonPanel.setLayout(new java.awt.GridLayout(1, 3));
            buttonPanel.add(button1);
            buttonPanel.add(button2);
            buttonPanel.add(button3);

            tab1.add(buttonPanel, java.awt.BorderLayout.NORTH);
            tab1.add(new javax.swing.JScrollPane(list), java.awt.BorderLayout.CENTER);

            tabbedPane.addTab("Blocks", tab1);
            tabbedPane.addTab("Tab 2", tab2);

            button1.addActionListener(e1 -> {
                JFrame popUpFrame1 = new JFrame("Input Blocks");
                popUpFrame1.setSize(300, 200);
                popUpFrame1.setLayout(new java.awt.GridLayout(5, 2));

                popUpFrame1.add(new javax.swing.JLabel("Mass:"));
                javax.swing.JTextField input1 = new javax.swing.JTextField();
                popUpFrame1.add(input1);

                popUpFrame1.add(new javax.swing.JLabel("Velocity:"));
                javax.swing.JTextField input2 = new javax.swing.JTextField();
                popUpFrame1.add(input2);

                popUpFrame1.add(new javax.swing.JLabel("Acceleration:"));
                javax.swing.JTextField input3 = new javax.swing.JTextField();
                popUpFrame1.add(input3);

                popUpFrame1.add(new javax.swing.JLabel("Jerk:"));
                javax.swing.JTextField input4 = new javax.swing.JTextField();
                popUpFrame1.add(input4);

                javax.swing.JButton submitButton = new javax.swing.JButton("Submit");
                popUpFrame1.add(submitButton);
                popUpFrame1.setLocationRelativeTo(frame);
                submitButton.addActionListener(event -> {
                    String input1Text = input1.getText();
                    String input2Text = input2.getText();
                    String input3Text = input3.getText();
                    String input4Text = input4.getText();

                    if (input1Text.isEmpty() || input2Text.isEmpty() || input3Text.isEmpty() || input4Text.isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(popUpFrame, "All fields must be filled.",
                                "Input Error",
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
                        popUpFrame1.dispose();
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(popUpFrame, "All inputs must be numeric.",
                                "Input Error",
                                javax.swing.JOptionPane.ERROR_MESSAGE);

                    }

                    // Handle the input values here
                    int m = Integer.parseInt(input1.getText());
                    int v = Integer.parseInt(input2.getText());
                    int f1 = Integer.parseInt(input3.getText());
                    int f2 = Integer.parseInt(input4.getText());
                    // System.out.println("Mass: " + m);
                    // Process the values as needed
                    popUpFrame1.dispose();
                    Blocks newBlock = U.newBlock(m, v, f1, f2, "Block " + blk.size());
                    blk.add(newBlock);
                    newBlock.print();
                    moveBlock(newBlock, drawPanel, drawPanel.getGraphics());
                    listModel.addElement(newBlock.getName());
                });
                
                popUpFrame1.setLocationRelativeTo(frame);
                popUpFrame1.setVisible(true);
            });
            popUpFrame.add(tabbedPane);
            popUpFrame.setLocationRelativeTo(frame);
            popUpFrame.setVisible(true);
        });

    }

    public static Utility U = new Utility();
  
    public static ArrayList<Blocks> blk = new ArrayList<>();

    public static void moveBlock(Blocks b, javax.swing.JPanel p, java.awt.Graphics g) {
        // move block
        // Example drawing code
        java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;

        java.awt.Image img = b.getBlockImage();
        p.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                b.setX(e.getX());
                b.setY(e.getY());
                Utility.rePaint(blk, blk.size(), g2d, p);
                g2d.drawImage(img, e.getX() - 14, e.getY() - 27, p);
            }
        });
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) { // Right-click
                    Utility.rePaint(blk, blk.size(), g2d, p);
                    g2d.drawImage(img, e.getX() - 14, e.getY() - 27, p);
                    b.setX(e.getX());
                    b.setY(e.getY());
                    p.removeMouseMotionListener(p.getMouseMotionListeners()[0]);
                    p.removeMouseListener(p.getMouseListeners()[0]);
                }
            }
        });

    }
}
