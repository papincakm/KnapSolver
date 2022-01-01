package com.company.data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConKnapSolutionW extends DataFileWrapper<KnapSolution> {
    public KnapSolution read(String line) {
        try {
            StringTokenizer st = new StringTokenizer(line);
            int id = Math.abs(Integer.parseInt(st.nextToken())) - 1;
            int itemCount = Integer.parseInt(st.nextToken());
            int bestPrice = Integer.parseInt(st.nextToken());

            List<Boolean> itemUsedList = new ArrayList<Boolean>();
            for (int i = 0; i < itemCount; i++) {
                int candidate = Integer.parseInt(st.nextToken());
                if (candidate == 0)
                    itemUsedList.add(false);
                else
                    itemUsedList.add(true);
            }

            return new KnapSolution(id, itemCount, bestPrice, itemUsedList);
        } catch (Exception e) {
            System.out.println("DecKnapInstanceW - cant read line.");
            return new KnapSolution(1, 1, 1, new ArrayList<Boolean>());
        }
    }
}
