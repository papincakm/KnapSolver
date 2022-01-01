package com.company.tests;

import com.company.data.KnapInstance;
import com.company.data.KnapInstanceW;
import com.company.io.FileReader;
import com.company.knap.GreedyKnapSolver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class GreedyKnapTest {
    @Test
    public void testResult() throws Exception {
        URL instancesResource = getClass().getClassLoader().getResource("NK4_inst.dat");
        List<KnapInstance> instList = new FileReader<KnapInstance>().read(new KnapInstanceW(),
                instancesResource.getPath());

        System.out.println(new GreedyKnapSolver(instList.get(0)).solve());
    }
}
