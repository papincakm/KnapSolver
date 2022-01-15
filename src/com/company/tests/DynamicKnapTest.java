package com.company.tests;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;
import com.company.io.KnapInstanceEditor;
import com.company.io.KnapSolutionEditor;
import com.company.knap.ConstructRecSolver;
import com.company.knap.DynamicSolver;
import com.company.utils.Utils;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;
import java.util.ListIterator;

public class DynamicKnapTest {
    @Test
    public void testResult() throws Exception {
        //TODO: create specific instances to test
        URL instancesResource = getClass().getClassLoader().getResource("NK4_inst.dat");
        List<KnapInstance> instList = new KnapInstanceEditor().readFile(instancesResource.getPath());

        URL solutionsResource = getClass().getClassLoader().getResource("firstHW_nr_NK4_sol.dat");
        List<KnapSolution> solList = new KnapSolutionEditor().readFile(solutionsResource.getPath());

        ListIterator<KnapSolution> solIt = solList.listIterator();
        for (KnapInstance i : instList) {
            KnapSolution solution = new DynamicSolver().solve(i);
            if (!solution.equals(solList.get(i.id()))) {
                System.out.println(solution);
                System.out.println(solList.get(solution.id()));
                throw new Exception();
            }
        }
    }
}
