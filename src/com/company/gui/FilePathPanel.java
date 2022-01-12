package com.company.gui;

import javax.swing.*;
import java.awt.*;

public class FilePathPanel extends CellPanel{
    final private static int width = 150;
    final private static int height = 25;
    final private static String labelString = "Instance File";

    final TextField filePath;

    FilePathPanel() {
        super(width, height);

        filePath = new TextField(width);
        filePath.setText("D:\\skola\\KOP\\ni-kop\\kop2\\kopSec\\NK\\NK4_inst.dat");
        add(filePath);
    }

    public static JPanel getLabelPanel() {
        return getLabelPanel(labelString, width, height);
    }

    public String getFilePath() {
        return filePath.getText();
    }
}
