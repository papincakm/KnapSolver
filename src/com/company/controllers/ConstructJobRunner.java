package com.company.controllers;

import com.company.data.Job;
import com.company.data.KnapInstance;
import com.company.data.KnapSolution;
import com.company.io.KnapInstanceEditor;
import com.company.knap.KnapSolver;
import com.company.knap.SolverFactory;

import java.util.List;

public class ConstructJobRunner implements JobRunner{
    public void run(Job job) {
        List<KnapInstance> instList = new KnapInstanceEditor().readFile(job.instanceFilePath());
        KnapSolver<KnapInstance> solver = SolverFactory.create(job.algorithm());

        for (KnapInstance i : instList) {
            KnapSolution solution = solver.solve(i);
            System.out.println(solution);
        }
    }
}
