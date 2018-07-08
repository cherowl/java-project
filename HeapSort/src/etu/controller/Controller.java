package etu.controller;

import etu.view.Graphics;
import etu.view.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

//import static com.sun.java.util.jar.pack.Package.*;

public class Controller {
    private static JMenu fileMenu = new JMenu("File");

    private static JMenuItem saveItem = new JMenuItem("Save graph");
    private static JMenuItem exitItem = new JMenuItem("Exit");

    public static JMenu doFileMenu() {
        fileMenu.add(saveItem);
        saveAction();

        fileMenu.add(exitItem);
        exitAction();
        return fileMenu;
    }

    public static void saveAction() {
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                saveImage(View.graph);
            }
        });
    }

    public static void exitAction() {
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void saveImage(JPanel panel) {
        BufferedImage image = (BufferedImage)
                panel.createImage(panel.getWidth(), panel.getHeight());
        Graphics g2 = (Graphics) image.createGraphics();
        panel.paint((java.awt.Graphics) g2);
//        g2.dispose();
//        try {
//            boolean jpeg = ImageIO.write(image, "jpeg", new com.sun.java.util.jar.pack.*("MyImg.jpeg"));
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
    }

}
