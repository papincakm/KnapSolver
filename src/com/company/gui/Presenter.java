package com.company.gui;

import com.company.controllers.Controller;
import com.company.data.Job;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    public static MainWindow mainWindow;
    public static JFrame mainFrame;

    public Presenter() {
        mainWindow = new MainWindow();
    }

    public static void showMain() {

    }

    public static void runJobs(List<String> instancePathList, List<String> algorithmList) {
        List<Job> jobList = new ArrayList<Job>();

        for (int i = 0; i < instancePathList.size(); i++) {
            jobList.add(new Job(instancePathList.get(i), " ", Job.Algorithm.valueOf(algorithmList.get(i))));
        }

        Controller.runJobs(jobList);
    }
}
