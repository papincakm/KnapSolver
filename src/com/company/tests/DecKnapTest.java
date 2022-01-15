package com.company.tests;

import com.company.data.*;
import com.company.io.DecKnapInstanceEditor;
import com.company.io.KnapSolutionEditor;
import com.company.knap.DecisionRecSolver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class DecKnapTest {
    @Test
    public void testResult() throws Exception {
        URL instancesResource = getClass().getClassLoader().getResource("firstHW_nr_NR4_inst.dat");
        List<DecKnapInstance> instList = new DecKnapInstanceEditor().readFile(instancesResource.getPath());

        URL solutionsResource = getClass().getClassLoader().getResource("firstHW_nr_NK4_sol.dat");
        List<KnapSolution> solList = new KnapSolutionEditor().readFile(solutionsResource.getPath());

        for (DecKnapInstance i : instList) {
            KnapSolution solution = new DecisionRecSolver().solve(i);

            if (solution.bestPrice() < i.minPrice() && solution.bestPrice() != 0) {
                throw new Exception();
            }

            if (solution.bestPrice() == 0 && solList.get(solution.id()).bestPrice() >= i.minPrice() &&
                    i.minPrice() != 0) {
                throw new Exception();
            }
        }
    }
}
