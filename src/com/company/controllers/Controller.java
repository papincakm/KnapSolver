package com.company.controllers;

import com.company.data.Job;
import com.company.gui.Presenter;

import java.util.List;

public class Controller {
    protected static Presenter presenter;

    public Controller() {
        presenter = new Presenter();
        presenter.showMain();
    };

    public static void runJobs(List<Job> jobList) {
        for (Job j : jobList) {
            JobRunnerFactory.create(j.algorithm()).run(j);
        }
    }
}
