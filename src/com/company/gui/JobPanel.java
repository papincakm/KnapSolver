package com.company.gui;

import javax.swing.*;
import java.awt.*;

public class JobPanel extends JPanel {
    FilePathPanel filePathPanel;
    ChooseAlgorithmPanel chooseAlgorithmPanel;
    RunPanel runPanel;

    JobPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBorder((BorderFactory.createLineBorder(Color.BLACK)));

        filePathPanel = new FilePathPanel();
        chooseAlgorithmPanel = new ChooseAlgorithmPanel();
        runPanel = new RunPanel();

        add(filePathPanel);
        add(chooseAlgorithmPanel);
        add(runPanel);
    }
}
