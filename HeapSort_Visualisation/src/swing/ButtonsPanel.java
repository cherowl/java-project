package src.swing;

import javax.swing.*;
import javax.swing.event.AncestorListener;

public class ButtonsPanel extends JPanel {
    private final JButton ReadArrButt = createButton("Read Graph", 850, 5); // x - shift of left edg, y- shift of up edg
    private final JButton CleanFieldButt = createButton("Clean", 750, 5);

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 90, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        return left;
    }

    public ButtonsPanel() {
        super(null);
        add(ReadArrButt);
        add(CleanFieldButt);
    }

    public void addReadArrListener(AncestorListener listener) {
        ReadArrButt.addAncestorListener(listener);
    }

    public void addCleanListener(AncestorListener listener) {
        ReadArrButt.addAncestorListener(listener);
    }


}