package com.company.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class CellPanel extends JPanel {
    CellPanel(int width, int height) {
        setLayout(new BorderLayout());
        setBorder((BorderFactory.createLineBorder(Color.BLACK)));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
    }

    protected JPanel getLabelPanel(String labelString, int width, int height) {
        JPanel panel = new JPanel();
        panel.setMinimumSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));

        JLabel label = new JLabel(labelString);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(label);
        return panel;
    }

    public abstract JPanel getLabelPanel();
}
