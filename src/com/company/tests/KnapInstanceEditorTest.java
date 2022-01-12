package com.company.tests;

import com.company.data.Item;
import com.company.data.KnapInstance;
import com.company.data.KnapSolution;
import com.company.io.FileReader;
import com.company.io.KnapInstanceEditor;
import com.company.knap.ConstructProblemSolver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapInstanceEditorTest {
    @Test
    public void testResult() throws Exception {
        URL instancesResource = getClass().getClassLoader().getResource("NK4_inst.dat");
        List<KnapInstance> instList = new KnapInstanceEditor().readFile(instancesResource.getPath());

        KnapInstance i = instList.get(0);
        if (i.id() != 0 || i.itemCount() != 4 || i.capacity() != 46 ||
                !i.itemList().equals(new ArrayList(){{
                    add(new Item(0, 36, 3));
                    add(new Item(1, 43, 1129));
                    add(new Item(2, 202, 94));
                    add(new Item (3, 149, 2084));
                }})) {
            throw new Exception();
        }
    }
}
