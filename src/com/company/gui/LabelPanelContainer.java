package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LabelPanelContainer extends JPanel implements CellPanelO {
    private final List<JPanel> labelPanelList;

    LabelPanelContainer(List<JPanel> panelList) {
        labelPanelList = new ArrayList<>();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);

        for (JPanel p : panelList) {
            labelPanelList.add(p);
            add(p);
        }
    }

    //TODO: refactor
    public void update(List<CellPanel> cellPanelList) {
        int labelTypeCount = cellPanelList.size() / labelPanelList.size();

        for (int i = 0; i < labelPanelList.size(); i++) {
            for (int j = 0; j < cellPanelList.size(); j += labelTypeCount) {
                int candidate = cellPanelList.get(j).getWidth();
                if(labelPanelList.get(i).getWidth() < candidate) {
                    labelPanelList.get(i).setMinimumSize(new Dimension(candidate, labelPanelList.get(i).getHeight()));
                    labelPanelList.get(i).setMaximumSize(new Dimension(candidate, labelPanelList.get(i).getHeight()));
                }
            }
        }
    }
}
