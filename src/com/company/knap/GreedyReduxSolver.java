package com.company.knap;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;
import com.company.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyReduxSolver extends GreedySolver {
    public GreedyReduxSolver() {}

    @Override
    public KnapSolution solve(KnapInstance instance) {
        this.instance = instance;
        KnapSolution candidate = greedySolve();
        int maxId = instance.getMaxPricedItem().id();

        if (instance.itemList().get(maxId).price() > candidate.bestPrice() &&
            instance.itemList().get(maxId).weight() <= instance.capacity()) {
            List<Boolean> usedItems = new ArrayList<Boolean>(Collections.nCopies(instance.itemCount(), false));
            usedItems.set(maxId, true);
            return new KnapSolution(instance.id(), instance.itemCount(), instance.itemList().get(maxId).price(),
                    new ArrayList<Boolean>(usedItems));
        }
        return candidate;
    }
}
