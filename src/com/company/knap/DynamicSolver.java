package com.company.knap;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;
import com.company.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynamicSolver extends KnapSolver<KnapInstance> {
    public DynamicSolver() {
    }

    public KnapSolution solve(KnapInstance instance) {
        this.instance = instance;
        return dynamicSolve(instance);
    }

    protected KnapSolution dynamicSolve(KnapInstance instance) {
        int bestI = 0;
        int moreThanMaxWeight = instance.getMaxWeightSum() + 1;
        int maxPrice = instance.getMaxPriceSum() + 1;
        Integer[][] table = new Integer[maxPrice + 1][instance.itemCount() + 1];
        for (int i = 0; i <= maxPrice; i++) {
            for (int j = 0; j <= instance.itemCount(); j++) {
                table[i][j] = 0;
            }
        }

        for (int i = 1; i <= maxPrice; i++) {
            for (int j = 0; j <= instance.itemCount(); j++) {
                if (j == 0)
                    table[i][j] = moreThanMaxWeight;
                else if (instance.itemList().get(j - 1).price() <= i) {
                    table[i][j] = Math.min(table[i][j - 1],
                            table[i - instance.itemList().get(j - 1).price()][j - 1] +
                                    instance.itemList().get(j - 1).weight());
                }
                else
                    table[i][j] = table[i][j - 1];

                if (j == instance.itemCount() && i >= bestI && table[i][j] <= instance.capacity()) {
                    bestI = i;
                }
            }
        }

        return new KnapSolution(instance.id(), instance.itemCount(), bestI,
                new ArrayList<Boolean>(getUsedItems(table, bestI)));
    }

    //backtrack from final price through filled table to get the selected items
    protected List<Boolean> getUsedItems(Integer[][] dataTable, int price) {
        List<Boolean> usedItems = new ArrayList<Boolean>(Collections.nCopies(instance.itemCount(), false));
        for (int i = instance.itemCount(); i > 0; i--) {
            if (!dataTable[price][i].equals(dataTable[price][i - 1]) && !usedItems.get(i - 1)) {
                usedItems.set(i - 1, true);
                price -= instance.itemList().get(i - 1).price();
            }
        }
        return usedItems;
    }

    protected List<List<Integer>> generateZeroTable(int x, int y) {
        List<List<Integer>> table = new ArrayList<List<Integer>>();

        for (int i = 0; i < x; i++) {
            table.add(new ArrayList<Integer>(Collections.nCopies(y, 0)));
        }

        return table;
    }
}
