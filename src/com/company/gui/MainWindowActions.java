package com.company.gui;

public class MainWindowActions {
    public static void handleReadFile(String filePath) {
        Presenter.readFile(filePath);
    }
    public static void handleAddJob() { Presenter.addJob();}
}
