package com.physix.classes;

import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.physix.App;
public class ShowFile {
   
    private final ArrayList<Image> images = new ArrayList<>();
    public void addImage(Image image) {
        this.images.add(image);
    }
    public Image getImage(int index) {
        return this.images.get(index);
    }
    public void removeImage(int index) {
        this.images.remove(index);
    }
    public void print() {
        for (Image image : this.images) {
            System.out.println(image);
        }
    }
    public void clear() {
        this.images.clear();
    }
    public int size() {
        return this.images.size();
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public void saveFile() {
        
        App.frame.setVisible(false);
        ShowFrame.frame.setVisible(false);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save file");
        File parentDir = new File(System.getProperty("user.dir"), "demo/files");
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
        fileChooser.setCurrentDirectory(parentDir);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".phx");
            }

            @Override
            public String getDescription() {
                return "PhysiX Files (*.phx)";
            }
        });
        int option = fileChooser.showSaveDialog(null);
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            
            if (!file.getName().toLowerCase().endsWith(".phx")) {
                file = new File(file.getAbsolutePath() + ".phx");
            }
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                
                for (Image image : this.images) {
                    File outputfile = new File(file.getParent(), "image" + this.images.indexOf(image) + ".png");
                    
                    try {
                        javax.imageio.ImageIO.write((java.awt.image.RenderedImage) image, "png", outputfile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    writer.println(image.toString());
                }
                JOptionPane.showMessageDialog(null, "File saved successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Save command canceled.");
        }
        App.frame.setVisible(true);
        ShowFrame.frame.setVisible(true);
      }
}
