package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobPanel extends JPanel {
    private final FilePathPanel instanceFilePathPanel;
    private final ChooseAlgorithmPanel chooseAlgorithmPanel;
    private final List<CellPanel> cellPanelList;
    JobPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBorder((BorderFactory.createLineBorder(Color.BLACK)));

        instanceFilePathPanel = new FilePathPanel("Instance",
                getClass().getClassLoader().getResource("NK4_inst.dat").getPath());
        FilePathPanel solutionFilePathPanel = new FilePathPanel("Expected Solution",
                getClass().getClassLoader().getResource("firstHW_nr_NK4_sol.dat").getPath());
        FilePathPanel resultFilePathPanel = new FilePathPanel("Output Solution", System.getProperty("user.dir"));
        chooseAlgorithmPanel = new ChooseAlgorithmPanel();
        RunPanel runPanel = new RunPanel();

        cellPanelList = new ArrayList<>();
        cellPanelList.add(instanceFilePathPanel);
        cellPanelList.add(solutionFilePathPanel);
        cellPanelList.add(resultFilePathPanel);
        cellPanelList.add(chooseAlgorithmPanel);
        cellPanelList.add(runPanel);

        for (CellPanel p : cellPanelList) {
            add(p);
        }
    }

    public List<JPanel> getLabelPanelList() {
        List<JPanel> labelPanelList = new ArrayList<>();
        for (CellPanel p : cellPanelList) {
            labelPanelList.add(p.getLabelPanel());
        }
        return labelPanelList;
    }

    public String getInstanceFilePath() {
        return instanceFilePathPanel.getFilePath();
    }

    public String getChosenAlgorithm() {
        return chooseAlgorithmPanel.getChosenAlgorithm();
    }

    public List<CellPanel> getCellPanelList() {
        return cellPanelList;
    }
}
