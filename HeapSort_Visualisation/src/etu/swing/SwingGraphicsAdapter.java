package etu.swing;

import etu.view.Graphics;

import javax.swing.*;
import java.awt.*;

public class SwingGraphicsAdapter implements Graphics {
    private final JFrame mainFrame;
    private final java.awt.Graphics graphics;

    public SwingGraphicsAdapter(JFrame mainFrame, java.awt.Graphics graphics) {
        this.mainFrame = mainFrame;
        this.graphics = graphics;
    }

    @Override
    @SuppressWarnings("SuspiciousNameCombination")
    public void drawRect(int x, int y, int width, int height, int rgb, int data) {
        graphics.setColor(new Color(rgb));

        graphics.fillRect(y, x, width, height);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y2);
    }

    @Override
    public void showThanks() {
        JOptionPane.showConfirmDialog(mainFrame, "Thanks for using!", "Congratulations", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}
