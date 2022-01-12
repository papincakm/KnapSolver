package com.company.gui;

import com.company.knap.KnapSolver;

import javax.swing.*;
import java.awt.*;

public class ChooseAlgorithmPanel extends CellPanel {
    final private static int width = 120;
    final private static int height = 25;
    final private static String labelString = "Algorithm";
    public static String[] algorithms = { "Constructive", "Decision", "Dynamic", "FPTAS", "Greedy", "GreedyRedux" };

    final JComboBox algorithmList;

    ChooseAlgorithmPanel() {
        super(width, height);

        algorithmList = new JComboBox(algorithms);
        add(algorithmList);
    }

    public static JPanel getLabelPanel() {
        return getLabelPanel(labelString, width, height);
    }

    public String getChosenAlgorithm() {
        return algorithmList.getSelectedItem().toString();
    }
}