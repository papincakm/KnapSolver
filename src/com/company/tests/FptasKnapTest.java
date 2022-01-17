package com.company.tests;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;
import com.company.io.KnapInstanceEditor;
import com.company.io.KnapSolutionEditor;
import com.company.knap.DynamicSolver;
import com.company.knap.FptasSolver;
import com.company.knap.GreedySolver;
import com.company.utils.Utils;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class FptasKnapTest {
    @Test
    public void testResult() throws Exception {
        //TODO: create specific instances to test
        URL instancesResource = getClass().getClassLoader().getResource("NK4_inst.dat");
        List<KnapInstance> instList = new KnapInstanceEditor().readFile(instancesResource.getPath());

        URL solutionsResource = getClass().getClassLoader().getResource("firstHW_nr_NK4_sol.dat");
        List<KnapSolution> solList = new KnapSolutionEditor().readFile(solutionsResource.getPath());

        List<Double> errorList = new ArrayList<Double>(Arrays.asList(0.1, 0.3, 0.5, 0.7, 0.9));

        for (Double e : errorList) {
            ListIterator<KnapSolution> solIt = solList.listIterator();
            for (KnapInstance i : instList) {
                KnapSolution solution = new FptasSolver(e).solve(i);
                Double error = Utils.countRelativeError(solution, solIt.next());
                if (error > e) {
                    System.out.println("my sol on error " + e + " " + solution);
                    System.out.println(solList.get(solution.id()));
                    throw new Exception();
                }
            }
        }
    }
}
