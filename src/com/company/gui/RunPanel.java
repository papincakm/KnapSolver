package com.company.gui;

import javax.swing.*;

public class RunPanel extends CellPanel{
    final private static int width = 25;
    final private static int height = 25;
    final private static String labelString = "Run";

    RunPanel() {
        super(width, height);

        JCheckBox runBox = new JCheckBox();
        runBox.setSelected(true);
        add(runBox);
    }

    public static JPanel getLabelPanel() {
        return getLabelPanel(labelString, width, height);
    }
}
