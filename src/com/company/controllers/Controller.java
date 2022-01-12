package com.company.controllers;

import com.company.data.DecKnapInstance;
import com.company.data.Job;
import com.company.gui.Presenter;
import com.company.io.FileReader;
import com.company.knap.DecisionProblemSolver;

import java.util.List;

public class Controller {
    protected static Presenter presenter;

    public Controller() {
        presenter = new Presenter();
        presenter.showMain();
    };

    public static void readFile(String filePath) {
        List<DecKnapInstance> instList = new FileReader<DecKnapInstance>().read(filePath, new DecKnapInstance());
        for (DecKnapInstance i : instList) {
            System.out.println(new DecisionProblemSolver(i).solve());
        }
    }

    public static void runJobs(List<Job> jobList) {
        for (Job j : jobList) {
            JobRunner.run(j);
        }
    }
}
