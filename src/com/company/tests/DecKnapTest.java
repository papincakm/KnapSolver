package com.company.tests;

import com.company.data.DecKnapInstance;
import com.company.data.DecKnapInstanceW;
import com.company.io.FileReader;
import com.company.knap.DecKnapSolver;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class DecKnapTest {
    @Test
    public void testResult() throws Exception {
        URL resource = getClass().getClassLoader().getResource("firstHW_nr_NR4_inst.dat");

        List<DecKnapInstance> instList = new FileReader<DecKnapInstance>().read(new DecKnapInstanceW(),
                resource.getPath());
        for (DecKnapInstance i : instList) {
            System.out.println(new DecKnapSolver(i).solve());
        }
        throw new Exception();
    }
}
