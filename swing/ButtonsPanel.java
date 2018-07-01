package etu.swing;

import javax.swing.*;

public class ButtonsPanel extends JPanel {
    private final JButton ReadGraphButt = new JButton("Read Graph");
    private final JButton CleanField = new JButton("Clean Canvas");

    public ButtonsPanel() {
        super(null);
        add(ReadGraphButt);
        add(CleanField);
    }


}
