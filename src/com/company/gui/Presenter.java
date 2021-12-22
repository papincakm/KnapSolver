package com.company.gui;

import com.company.Controller;

import javax.swing.JFrame;

public class Presenter {
    public static MainWindow mainWindow;
    public static JFrame mainFrame;

    public Presenter() {
        /*mainFrame = new JFrame("KnapSolver");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        mainWindow = new MainWindow();
    }

    public static void showMain() {
        /*mainFrame.setContentPane(mainWindow.$$$getRootComponent$$$());
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);*/
        mainWindow.setVisible(true);
    }

    public static void readFile(String filePath) {
        //Controller.readFile(filePath);
        Controller.readFile("C:\\Users\\marek\\Downloads\\firstHW_nr_NR4_inst.dat");
    }
}
