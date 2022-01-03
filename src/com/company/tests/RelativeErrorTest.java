package com.company.tests;

import com.company.data.KnapSolution;
import com.company.utils.Utils;
import org.junit.Test;

import java.util.Collections;

public class RelativeErrorTest {
    @Test
    public void testResult() throws Exception {
        KnapSolution first = new KnapSolution(1, 4, 1, Collections.nCopies(4, false));
        KnapSolution second = new KnapSolution(1, 4, 5, Collections.nCopies(4, false));

        double relError = Utils.countRelativeError(first, second);
        System.out.println(relError);
        if (relError - 0.8 > 0.00001)
            throw new Exception();
    }
}
