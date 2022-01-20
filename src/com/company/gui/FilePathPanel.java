package com.company.gui;

import javax.swing.*;
import java.awt.*;

public class FilePathPanel extends CellPanel {
    final private static int width = 200;
    final private static int height = 25;
    final private String labelString;

    final TextField filePath;

    FilePathPanel(String label, String defaultText) {
        super(width, height);

        filePath = new TextField(width);
        labelString = label;
        filePath.setText(defaultText);
        add(filePath);
    }

    public JPanel getLabelPanel() {
        return getLabelPanel(labelString, width, height);
    }

    public String getFilePath() {
        return filePath.getText();
    }

}
