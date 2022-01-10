package com.company.gui;

import javax.swing.*;
import java.awt.*;

public class LabelPanel extends JPanel{
    LabelPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);

        add(FilePathPanel.getLabelPanel());
        add(ChooseAlgorithmPanel.getLabelPanel());
        add(RunPanel.getLabelPanel());
    }
}
