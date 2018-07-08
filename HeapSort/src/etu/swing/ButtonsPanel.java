package etu.swing;

<<<<<<< HEAD
import etu.model.FileReadArray;
import etu.model.heapsort.HeapSort;
=======
import etu.view.View;
>>>>>>> master

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ButtonsPanel extends JPanel {
<<<<<<< HEAD
    private final JButton StartSort = createButton("Sort", 40, 10);
=======
    private final JButton StartSort = createButton("Push me", 40, 10);
    private final JLabel check = createLabel("lalalla", 40, 250);
//    private final JFrame mainFrame;
>>>>>>> master

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 100, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        left.setBackground(Color.LIGHT_GRAY);
        return left;
    }

    private JLabel createLabel(String text, int x, int y){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 40);
//        label.(true);
        return label;
    }

    public ButtonsPanel() {
        add(StartSort);
        add(check);
        StartSort.addActionListener(new ActionListener() {
//            private JEditorPane jTextArea1;
//            View view = new View(mainFrame);
//            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
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
=======
//                view.showThanksDialog();
//                System.out.println("Я кнопка и я работаю");
>>>>>>> master
            }
        });
    }

//    public void addStartSort(AncestorListener listener) {
//        StartSort.addAncestorListener(listener);
//    }

//    @Override
//    public void showCongratsDialog() {
//        JOptionPane.showConfirmDialog(mainFrame, "You are winner!", "Congratulations", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
//    }
}