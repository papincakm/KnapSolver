package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel jobPanelContainer;
    private JPanel buttonBottomContainer;

    MainWindow() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonBottomContainer = new JPanel();
        buttonBottomContainer.setLayout(new BoxLayout(buttonBottomContainer, BoxLayout.X_AXIS));
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JPanel newPanel = new JobPanel();
                jobPanelContainer.add(newPanel, BorderLayout.WEST);
                jobPanelContainer.revalidate();
                // Scroll down to last added panel
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        newPanel.scrollRectToVisible(newPanel.getBounds());
                    }
                });
            }
        });
        buttonBottomContainer.add(addButton);

        JButton runButton = new JButton("Run Selected");
        frame.add(runButton, BorderLayout.PAGE_END);
        buttonBottomContainer.add(runButton);

        frame.add(buttonBottomContainer, BorderLayout.PAGE_START);

        jobPanelContainer = new JPanel();
        //jobPanelContainer.setLayout(new FlowLayout());
        jobPanelContainer.setLayout(new BoxLayout(jobPanelContainer, BoxLayout.Y_AXIS));

        frame.add(new JScrollPane(jobPanelContainer), BorderLayout.CENTER);
        jobPanelContainer.add(new LabelPanel());

        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
