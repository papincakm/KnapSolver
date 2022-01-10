package com.company.gui;

import com.company.knap.KnapSolver;
import com.google.common.collect.Table;

import javax.swing.*;
import java.awt.*;

public class ChooseAlgorithmPanel extends CellPanel {
    final private static int width = 120;
    final private static int height = 25;
    final private static String labelString = "Algorithm";

    ChooseAlgorithmPanel() {
        super(width, height);

        JComboBox algorithmList = new JComboBox(KnapSolver.algorithms);
        add(algorithmList);
    }

    public static JPanel getLabelPanel() {
        return getLabelPanel(labelString, width, height);
    }
}