/**
 * The App class is the main entry point for the PhysiX application.
 * It sets up the main JFrame, menu bar, menus, and menu items.
 * It also handles the creation and management of blocks within the application.
 *
 * <p>
 * Features:
 * <ul>
 * <li>File menu with options to create, save, and open files.</li>
 * <li>Edit menu with an option to show an edit frame for blocks.</li>
 * <li>Options menu with options to run and run by step.</li>
 * <li>Help menu with settings, help, and about options.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The application includes a drawing panel for custom drawing and interaction
 * with blocks. Blocks can be created, edited, and deleted through the edit
 * frame.
 * </p>
 *
 * <p>
 * Usage:
 * <pre>
 * {@code
 * public static void main(String[] args) {
 *     App.main(args);
 * }
 * }
 * </pre>
 * </p>
 *
 * <p>
 * Dependencies:
 * <ul>
 * <li>javax.swing.JFrame</li>
 * <li>javax.swing.JMenu</li>
 * <li>javax.swing.JMenuBar</li>
 * <li>javax.swing.JMenuItem</li>
 * <li>com.physix.classes.Blocks</li>
 * <li>com.physix.utils.Utility</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: The application uses mouse listeners to handle block movement and
 * interaction.
 * </p>
 *
 * @see javax.swing.JFrame
 * @see javax.swing.JMenu
 * @see javax.swing.JMenuBar
 * @see javax.swing.JMenuItem
 * @see com.physix.classes.Blocks
 * @see com.physix.utils.Utility
 *
 * @author MPCBexplorer
 * @version 1.0.0AlphaSnapshot
 */

 
package com.physix;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.physix.classes.Blocks;
import com.physix.classes.ShowFile;
import com.physix.classes.ShowFrame;
import com.physix.classes.Vectors;
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
    public static JMenuItem menuItem2_1 = new JMenuItem("Option 1");
    public static JMenuItem menuItem2_2 = new JMenuItem("Run");
    public static JMenuItem menuItem2_3 = new JMenuItem("Run Setttings");
    // Create menu items for Menu 3
    public static JMenuItem menuItem3_1 = new JMenuItem("Settings");
    public static JMenuItem menuItem3_2 = new JMenuItem("Help");
    public static JMenuItem menuItem3_3 = new JMenuItem("About");

    /**
     * The main method serves as the entry point for the application. It sets up
     * the main JFrame, configures the menu bar with various menus and menu
     * items, and adds a drawing panel to the frame. It also sets up action
     * listeners for menu items to handle user interactions, such as editing,
     * adding, and deleting blocks.
     *
     * The main functionalities include: - Setting up the JFrame with default
     * close operation, size, and visibility. - Adding menus and menu items to
     * the menu bar. - Creating a drawing panel for custom drawing. - Handling
     * the "Edit Items" menu item to open a new JFrame with tabs for managing
     * blocks. - Providing functionalities to add, edit, and delete blocks. -
     * Updating the UI and repainting the drawing panel based on user
     * interactions.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        menu1.add(menuItem1_1);
        menu1.add(menuItem1_2);
        menu1.add(menuItem1_3);

        menu2x.add(menuItem2x_1);

        menu2.add(menuItem2_1);
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
        menuItem2x_1.addActionListener(e3 -> {
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
                        double m = Double.parseDouble(input1Text);
                        double v = Double.parseDouble(input2Text);
                        double f1 = Double.parseDouble(input3Text);
                        double f2 = Double.parseDouble(input4Text);

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
                    double m = Double.parseDouble(input1.getText());
                    double v = Double.parseDouble(input2.getText());
                    double a = Double.parseDouble(input3.getText());
                    double j = Double.parseDouble(input4.getText());
                    // System.out.println("Mass: " + m);
                    // Process the values as needed
                    popUpFrame1.dispose();
                    double[] agl = { 0, 0, 0 };
                    boolean[] waiting = { true, true, true };
                    if (v != 0) {
                        JFrame vaFrame = new JFrame("Input va");
                        vaFrame.setSize(300, 100);
                        vaFrame.setLayout(new java.awt.GridLayout(2, 2));

                        vaFrame.add(new javax.swing.JLabel("va:"));
                        javax.swing.JTextField vaInput = new javax.swing.JTextField();
                        vaFrame.add(vaInput);

                        javax.swing.JButton vaSubmitButton = new javax.swing.JButton("Submit");
                        vaFrame.add(vaSubmitButton);
                        vaFrame.setLocationRelativeTo(frame);

                        vaSubmitButton.addActionListener(vaEvent -> {
                            String vaText = vaInput.getText();
                            if (vaText.isEmpty()) {
                                javax.swing.JOptionPane.showMessageDialog(vaFrame, "va must be filled.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            try {
                                agl[0] = Double.parseDouble(vaText);
                                vaFrame.dispose();
                                waiting[0] = false;
                            } catch (NumberFormatException ex) {
                                javax.swing.JOptionPane.showMessageDialog(vaFrame, "va must be numeric.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }

                        });
                        vaFrame.setVisible(true);
                    } else {
                        waiting[0] = false;
                    }
                    if (a != 0) {
                        JFrame aaFrame = new JFrame("Input aa");
                        aaFrame.setSize(300, 100);
                        aaFrame.setLayout(new java.awt.GridLayout(2, 2));

                        aaFrame.add(new javax.swing.JLabel("aa:"));
                        javax.swing.JTextField aaInput = new javax.swing.JTextField();
                        aaFrame.add(aaInput);

                        javax.swing.JButton aaSubmitButton = new javax.swing.JButton("Submit");
                        aaFrame.add(aaSubmitButton);
                        aaFrame.setLocationRelativeTo(frame);

                        aaSubmitButton.addActionListener(aaEvent -> {
                            String aaText = aaInput.getText();
                            if (aaText.isEmpty()) {
                                javax.swing.JOptionPane.showMessageDialog(aaFrame, "aa must be filled.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            try {
                                agl[1] = Double.parseDouble(aaText);
                                aaFrame.dispose();
                                waiting[1] = false;
                            } catch (NumberFormatException ex) {
                                javax.swing.JOptionPane.showMessageDialog(aaFrame, "aa must be numeric.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }
                        });

                        aaFrame.setVisible(true);
                    } else {
                        waiting[1] = false;
                    }

                    if (j != 0) {
                        JFrame jaFrame = new JFrame("Input ja");
                        jaFrame.setSize(300, 100);
                        jaFrame.setLayout(new java.awt.GridLayout(2, 2));

                        jaFrame.add(new javax.swing.JLabel("ja:"));
                        javax.swing.JTextField jaInput = new javax.swing.JTextField();
                        jaFrame.add(jaInput);

                        javax.swing.JButton jaSubmitButton = new javax.swing.JButton("Submit");
                        jaFrame.add(jaSubmitButton);
                        jaFrame.setLocationRelativeTo(frame);

                        jaSubmitButton.addActionListener(jaEvent -> {
                            String jaText = jaInput.getText();
                            if (jaText.isEmpty()) {
                                javax.swing.JOptionPane.showMessageDialog(jaFrame, "ja must be filled.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            try {
                                agl[2] = Double.parseDouble(jaText);
                                jaFrame.dispose();
                                waiting[2] = false;
                            } catch (NumberFormatException ex) {
                                javax.swing.JOptionPane.showMessageDialog(jaFrame, "ja must be numeric.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }
                        });

                        jaFrame.setVisible(true);
                    } else {
                        waiting[2] = false;
                    }

                    @SuppressWarnings({"CallToPrintStackTrace", "SleepWhileInLoop"})
                    Thread t = new Thread(() -> {
                        while (waiting[0] || waiting[1] || waiting[2]) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Blocks newBlock = Utility.newBlock(m, new Vectors(v, agl[0]), new Vectors(a, agl[1]),
                                new Vectors(j, agl[2]), "Block " + blk.size());
                        blk.add(newBlock);
                        newBlock.print();
                        moveBlock(newBlock, drawPanel, drawPanel.getGraphics());
                        listModel.addElement(newBlock.getName());
                    });
                    t.start();
                });

                popUpFrame1.setLocationRelativeTo(frame);
                popUpFrame1.setVisible(true);
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
                input2.setText(String.valueOf(selectedBlock.getVelocity().getX()));
                popUpFrame2.add(input2);

                popUpFrame2.add(new javax.swing.JLabel("Acceleration:"));
                javax.swing.JTextField input3 = new javax.swing.JTextField();
                input3.setText(String.valueOf(selectedBlock.getAcceleration().getX()));
                popUpFrame2.add(input3);

                popUpFrame2.add(new javax.swing.JLabel("Jerk:"));
                javax.swing.JTextField input4 = new javax.swing.JTextField();
                input4.setText(String.valueOf(selectedBlock.getJerk().getX()));
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
                    String input5Text = input5.getText();

                    if (input1Text.isEmpty() || input2Text.isEmpty() || input3Text.isEmpty() || input4Text.isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(popUpFrame, "All fields must be filled.",
                                "Input Error",
                                javax.swing.JOptionPane.ERROR_MESSAGE);

                        return;
                    }

                    try {
                        double m = Double.parseDouble(input1Text);
                        double v = Double.parseDouble(input2Text);
                        double f1 = Double.parseDouble(input3Text);
                        double f2 = Double.parseDouble(input4Text);

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
                    double m = Double.parseDouble(input1.getText());
                    double v = Double.parseDouble(input2.getText());
                    double a = Double.parseDouble(input3.getText());
                    double j = Double.parseDouble(input4.getText());
                    // System.out.println("Mass: " + m);
                    // Process the values as needed
                    popUpFrame2.dispose();
                    double[] agl = { 0, 0, 0 };
                    boolean[] waiting = { true, true, true };
                    if (v != 0) {
                        JFrame vaFrame = new JFrame("Input va");
                        vaFrame.setSize(300, 100);
                        vaFrame.setLayout(new java.awt.GridLayout(2, 2));

                        vaFrame.add(new javax.swing.JLabel("va:"));
                        javax.swing.JTextField vaInput = new javax.swing.JTextField();
                        vaFrame.add(vaInput);

                        javax.swing.JButton vaSubmitButton = new javax.swing.JButton("Submit");
                        vaFrame.add(vaSubmitButton);
                        vaFrame.setLocationRelativeTo(frame);

                        vaSubmitButton.addActionListener(vaEvent -> {
                            String vaText = vaInput.getText();
                            if (vaText.isEmpty()) {
                                javax.swing.JOptionPane.showMessageDialog(vaFrame, "va must be filled.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            try {
                                agl[0] = Double.parseDouble(vaText);
                                vaFrame.dispose();
                                waiting[0] = false;
                            } catch (NumberFormatException ex) {
                                javax.swing.JOptionPane.showMessageDialog(vaFrame, "va must be numeric.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }

                        });

                        vaFrame.setVisible(true);
                    } else {
                        waiting[0] = false;
                    }

                    if (a != 0) {
                        JFrame aaFrame = new JFrame("Input aa");
                        aaFrame.setSize(300, 100);
                        aaFrame.setLayout(new java.awt.GridLayout(2, 2));

                        aaFrame.add(new javax.swing.JLabel("aa:"));
                        javax.swing.JTextField aaInput = new javax.swing.JTextField();
                        aaFrame.add(aaInput);

                        javax.swing.JButton aaSubmitButton = new javax.swing.JButton("Submit");
                        aaFrame.add(aaSubmitButton);
                        aaFrame.setLocationRelativeTo(frame);

                        aaSubmitButton.addActionListener(aaEvent -> {
                            String aaText = aaInput.getText();
                            if (aaText.isEmpty()) {
                                javax.swing.JOptionPane.showMessageDialog(aaFrame, "aa must be filled.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            try {
                                agl[1] = Double.parseDouble(aaText);
                                aaFrame.dispose();
                                waiting[1] = false;
                            } catch (NumberFormatException ex) {
                                javax.swing.JOptionPane.showMessageDialog(aaFrame, "aa must be numeric.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }
                        });

                        aaFrame.setVisible(true);
                    } else {
                        waiting[1] = false;
                    }

                    if (j != 0) {
                        JFrame jaFrame = new JFrame("Input ja");
                        jaFrame.setSize(300, 100);
                        jaFrame.setLayout(new java.awt.GridLayout(2, 2));

                        jaFrame.add(new javax.swing.JLabel("ja:"));
                        javax.swing.JTextField jaInput = new javax.swing.JTextField();
                        jaFrame.add(jaInput);

                        javax.swing.JButton jaSubmitButton = new javax.swing.JButton("Submit");
                        jaFrame.add(jaSubmitButton);
                        jaFrame.setLocationRelativeTo(frame);

                        jaSubmitButton.addActionListener(jaEvent -> {
                            String jaText = jaInput.getText();
                            if (jaText.isEmpty()) {
                                javax.swing.JOptionPane.showMessageDialog(jaFrame, "ja must be filled.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            try {
                                agl[2] = Double.parseDouble(jaText);
                                jaFrame.dispose();
                                waiting[2] = false;
                            } catch (NumberFormatException ex) {
                                javax.swing.JOptionPane.showMessageDialog(jaFrame, "ja must be numeric.",
                                        "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }
                        });

                        jaFrame.setVisible(true);
                    } else {
                        waiting[2] = false;
                    }
                    @SuppressWarnings({"CallToPrintStackTrace", "SleepWhileInLoop"})
                    Thread t = new Thread(() -> {
                        while (waiting[0] || waiting[1] || waiting[2]) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Blocks newBlock = Utility.newBlock(m, new Vectors(v, agl[0]), new Vectors(a, agl[1]),
                                new Vectors(j, agl[2]), input5Text);
                        moveBlock(newBlock, drawPanel, drawPanel.getGraphics());
                        blk.set(selectedIndex, newBlock);
                        listModel.set(selectedIndex, newBlock.getName());
                    });
                    t.start();
                });
                popUpFrame2.setLocationRelativeTo(frame);
                popUpFrame2.setVisible(true);
            });
            button3.addActionListener(e2 -> {
                int confirm = javax.swing.JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to delete this block?", "Confirm Delete",
                        javax.swing.JOptionPane.YES_NO_OPTION);
                if (confirm != javax.swing.JOptionPane.YES_OPTION) {
                    return;
                }
                int selectedIndex = list.getSelectedIndex();
                blk.remove(selectedIndex);
                listModel.remove(selectedIndex);
                button2.setEnabled(false);
                button3.setEnabled(false);
                Utility.rePaint(blk, (java.awt.Graphics2D) drawPanel.getGraphics(), drawPanel);
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

            popUpFrame.add(tabbedPane);
            popUpFrame.setLocationRelativeTo(frame);
            popUpFrame.setVisible(true);
        });
        // ShowFrame showFrame = new ShowFrame(showFile);
        menuItem2_2.addActionListener(e -> {
            String input = javax.swing.JOptionPane.showInputDialog(frame, "Enter the number of seconds to run:",
                    "Run Settings", javax.swing.JOptionPane.PLAIN_MESSAGE);
            int frameNumber = 0;
            if (input != null && !input.isEmpty()) {
                try {
                    int seconds = Integer.parseInt(input);
                    if (seconds > 0) {
                        // Handle the input value here
                        System.out.println("Running for " + seconds + " seconds.");
                        frameNumber = seconds * 25;
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(frame, "Please enter a positive integer.",
                                "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Input Error",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            ShowFile showFile = new ShowFile();
            while (frameNumber > 0) {
                // Run the simulation
                run();
                // Update the UI
                Utility.rePaint(blk, (java.awt.Graphics2D) drawPanel.getGraphics(), drawPanel);

                // Capture the drawPanel as an image
                java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(drawPanel.getWidth(),
                        drawPanel.getHeight(), java.awt.image.BufferedImage.TYPE_INT_RGB);
                java.awt.Graphics2D g2d = image.createGraphics();
                Utility.saveFrame(blk, g2d, drawPanel);
                // drawPanel.paintAll(g2d);
                showFile.addImage(image);

                g2d.dispose();
                frameNumber--;

            }
            @SuppressWarnings("unused")
            ShowFrame showFrame = new ShowFrame(showFile);

        });
    }

    // public static Utility U = new Utility();
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
                Utility.rePaint(blk, g2d, p);
                g2d.drawImage(img, e.getX() - 12, e.getY() - 25, p);
            }
        });
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) { // Right-click
                    Utility.rePaint(blk, g2d, p);
                    g2d.drawImage(img, e.getX() - 12, e.getY() - 25, p);
                    b.setX(e.getX());
                    b.setY(e.getY());
                    p.removeMouseMotionListener(p.getMouseMotionListeners()[0]);
                    p.removeMouseListener(p.getMouseListeners()[0]);
                }
            }
        });

    }

    public static void run() {
        // Run the simulation
        // Example code

        for (Blocks b : blk) {
            b.move();
        }
    }
}
