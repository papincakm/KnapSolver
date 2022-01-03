package com.company.tests;

import com.company.data.ConKnapSolutionW;
import com.company.data.KnapInstance;
import com.company.data.KnapInstanceW;
import com.company.data.KnapSolution;
import com.company.io.FileReader;
import com.company.knap.GreedySolver;
import com.company.utils.Utils;
import org.junit.Test;

import java.net.URL;
import java.util.List;
import java.util.ListIterator;

public class GreedyKnapTest {
    @Test
    public void testResult() throws Exception {
        //TODO: create specific instances to test
        URL instancesResource = getClass().getClassLoader().getResource("NK4_inst.dat");
        List<KnapInstance> instList = new FileReader<KnapInstance>().read(new KnapInstanceW(),
                instancesResource.getPath());

        URL solutionsResource = getClass().getClassLoader().getResource("firstHW_nr_NK4_sol.dat");
        List<KnapSolution> solList = new FileReader<KnapSolution>().read(new ConKnapSolutionW(),
                solutionsResource.getPath());

        ListIterator<KnapSolution> solIt = solList.listIterator();
        for (KnapInstance i : instList) {
            Utils.countRelativeError(new GreedySolver(i).solve(), solIt.next()));
        }
    }
}
