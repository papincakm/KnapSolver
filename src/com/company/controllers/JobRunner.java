package com.company.controllers;

import com.company.data.*;
import com.company.io.FileEditor;
import com.company.io.FileReader;
import com.company.io.KnapInstanceEditor;
import com.company.knap.SolverFactory;

import java.util.List;

public class JobRunner {
    public static void run(Job job) {
        KnapInstance reader = KnapInstanceFactory.create(job.algorithm());
        List<KnapInstance> instList = new KnapInstanceEditor().readFile(job.instanceFilePath());
        for (KnapInstance i : instList) {
            System.out.println(i.toString());
        }
        for (KnapInstance i : instList) {
            KnapSolution solution = SolverFactory.create(job.algorithm(), i).solve();
            System.out.println(solution);
        }
    }
}
