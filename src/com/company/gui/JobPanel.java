package com.company.gui;

import javax.swing.*;
import java.awt.*;

public class JobPanel extends JPanel {
    FilePathPanel instanceFilePathPanel;
    ChooseAlgorithmPanel chooseAlgorithmPanel;
    RunPanel runPanel;

    JobPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBorder((BorderFactory.createLineBorder(Color.BLACK)));

        instanceFilePathPanel = new FilePathPanel();
        chooseAlgorithmPanel = new ChooseAlgorithmPanel();
        runPanel = new RunPanel();

        add(instanceFilePathPanel);
        add(chooseAlgorithmPanel);
        add(runPanel);
    }
}
