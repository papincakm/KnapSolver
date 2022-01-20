package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainWindow {
    private final JPanel jobPanelContainer;
    private final JPanel buttonBottomContainer;
    private final List<JobPanel> jobPanelList;
    private final List<CellPanel> cellPanelList;
    private final JobPanelBuilder jobPanelBuilder;
    private final LabelPanelContainer labelPanelContainer;

    MainWindow() {
        jobPanelList = new ArrayList<JobPanel>();
        cellPanelList = new ArrayList<CellPanel>();

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonBottomContainer = new JPanel();
        buttonBottomContainer.setLayout(new BoxLayout(buttonBottomContainer, BoxLayout.X_AXIS));
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addJobPanel();
            }
        });
        buttonBottomContainer.add(addButton);

        JButton runButton = new JButton("Run Selected");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runJobs();
            }
        });
        frame.add(runButton, BorderLayout.PAGE_END);
        buttonBottomContainer.add(runButton);

        frame.add(buttonBottomContainer, BorderLayout.PAGE_START);

        jobPanelContainer = new JPanel();
        jobPanelContainer.setLayout(new BoxLayout(jobPanelContainer, BoxLayout.Y_AXIS));

        frame.add(new JScrollPane(jobPanelContainer), BorderLayout.CENTER);
        //TODO: refactor
        labelPanelContainer = new LabelPanelContainer(new JobPanel().getLabelPanelList());
        jobPanelContainer.add(labelPanelContainer);

        jobPanelBuilder = new JobPanelBuilder();
        jobPanelBuilder.add(labelPanelContainer);

        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private void addJobPanel() {
        jobPanelBuilder.make(jobPanelContainer, jobPanelList, cellPanelList);
    }

    private void runJobs() {
        List<String> instanceFilePathList = new ArrayList<String>();
        List<String> algorithmList = new ArrayList<String>();

        for (JobPanel j : jobPanelList) {
            instanceFilePathList.add(j.getInstanceFilePath());
            algorithmList.add(j.getChosenAlgorithm());
        }

        MainWindowActions.handleRunJobs(instanceFilePathList, algorithmList);
    }
}
