package com.company.controllers;

import com.company.data.*;
import com.company.io.DecKnapInstanceEditor;
import com.company.io.KnapInstanceEditor;
import com.company.knap.KnapSolver;
import com.company.knap.SolverFactory;

import java.util.List;

public class DecisionJobRunner implements JobRunner{
    public void run(Job job) {
        List<DecKnapInstance> instList = new DecKnapInstanceEditor().readFile(job.instanceFilePath());
        KnapSolver<DecKnapInstance> solver = SolverFactory.create(job.algorithm());

        for (DecKnapInstance i : instList) {
            KnapSolution solution = solver.solve(i);
            System.out.println(solution);
        }
    }
}
