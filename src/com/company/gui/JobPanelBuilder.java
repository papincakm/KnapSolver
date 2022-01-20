package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JobPanelBuilder {
    CellPanelO observer;

    public void make(JPanel panelContainer, List<JobPanel> jobPanelList, List<CellPanel> cellPanelList) {
        final JobPanel newPanel = new JobPanel();
        jobPanelList.add(newPanel);
        panelContainer.add(newPanel, BorderLayout.WEST);
        panelContainer.revalidate();
        // Scroll down to last added panel
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { newPanel.scrollRectToVisible(newPanel.getBounds());}
        });
        //TODO: refactor
        cellPanelList.addAll(newPanel.getCellPanelList());
        observer.update(cellPanelList);
    }

    public void add(CellPanelO observer) {
        this.observer = observer;
    }
}
