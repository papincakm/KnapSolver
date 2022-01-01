package com.company.tests;

import com.company.data.*;
import com.company.io.FileReader;
import com.company.knap.DecKnapSolver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class DecKnapTest {
    @Test
    public void testResult() throws Exception {
        URL instancesResource = getClass().getClassLoader().getResource("firstHW_nr_NR4_inst.dat");
        List<DecKnapInstance> instList = new FileReader<DecKnapInstance>().read(new DecKnapInstanceW(),
                instancesResource.getPath());

        URL solutionsResource = getClass().getClassLoader().getResource("firstHW_nr_NK4_sol.dat");
        List<KnapSolution> solList = new FileReader<KnapSolution>().read(new ConKnapSolutionW(),
                solutionsResource.getPath());

        for (DecKnapInstance i : instList) {
            KnapSolution solution = new DecKnapSolver(i).solve();

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
