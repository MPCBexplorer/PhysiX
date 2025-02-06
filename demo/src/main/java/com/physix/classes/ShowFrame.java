package com.physix.classes;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ShowFrame {
    public static JFrame frame = new JFrame("PhysiX-Run");
    public ShowFrame(ShowFile showFile) {
        
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setSize(800,610);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JSlider slider = new JSlider(1, showFile.size(), 1);
        JLabel valueLabel = new JLabel("Value: 0");
        JPanel panel = new JPanel();
        JLabel imageLabel = new JLabel();
        panel.add(imageLabel);
        slider.addChangeListener(e -> {
            valueLabel.setText("Value: " + slider.getValue());
            imageLabel.setIcon(new ImageIcon(showFile.getImage(slider.getValue()-1)));
        });

        bottomPanel.add(slider, BorderLayout.CENTER);
        bottomPanel.add(valueLabel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        JButton pauseButton = new JButton("Pause");

        

        buttonPanel.add(pauseButton);
        bottomPanel.add(buttonPanel, BorderLayout.WEST);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save as");
        JMenuItem openItem = new JMenuItem("Open");
        
        saveItem.addActionListener(e -> {
            showFile.saveFile();
        });
        
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(openItem);

        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        javax.swing.Timer timer = new javax.swing.Timer(40, e -> {
            imageLabel.setIcon(new ImageIcon(showFile.getImage(slider.getValue()-1)));
            int k=slider.getValue()+1;
            if (k == showFile.size()+1) {
                k=1;
            }
            slider.setValue(k);
        });
        pauseButton.addActionListener(e -> {
            if (timer.isRunning()) {
                timer.stop();
                pauseButton.setText("Resume");
            } else {
                timer.start();
                pauseButton.setText("Pause");
            }
        });
        timer.start();
        
        
    }
}
