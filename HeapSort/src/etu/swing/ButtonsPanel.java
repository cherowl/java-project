package etu.swing;

import etu.model.FileReadArray;
import etu.model.heapsort.HeapSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ButtonsPanel extends JPanel {
    private final JButton StartSort = createButton("Sort", 40, 10);

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 100, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        left.setBackground(Color.LIGHT_GRAY);
        return left;
    }

    public ButtonsPanel() {
        super(null);
        add(StartSort);
        StartSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner in = null;
                try {
                    in = new Scanner(new File("resource/input.dat"));
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                FileReadArray fileArr = FileReadArray.init(in);
                HeapSort hp = new HeapSort(fileArr.getArray());
                System.out.print("Sorted array: ");
                hp.printArray();

                System.out.print("Print KLP of binArr[0] tree: ");
                hp.getBinArr()[0].printTree(hp.getBinArr()[0].getRoot());
                System.out.println();
//                hp.getBinArr()[0].displayTree(hp.getBinArr()[0].getRoot(), 1);
            }
        });
    }


//    public void addStartSort(AncestorListener listener) {
//        StartSort.addAncestorListener(listener);
//    }
}