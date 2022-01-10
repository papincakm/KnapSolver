package com.company.knap;

import com.company.data.Item;
import com.company.data.KnapInstance;
import com.company.data.KnapSolution;

import java.util.*;

public class GreedySolver extends KnapSolver {

    public GreedySolver(KnapInstance knapInstance) {
        super(knapInstance);
    }

    public KnapSolution solve() {
        return greedySolve();
    }

    protected KnapSolution greedySolve() {
        int currentWeight = 0;
        int currentPrice = 0;
        List<Boolean> usedItems = new ArrayList<Boolean>(Collections.nCopies(instance.itemCount(), false));

        List<Item> instanceItems = new ArrayList<Item>(instance.itemList());
        instanceItems.sort((o1, o2) ->
                (int) (Math.ceil(((double) o2.price() / o2.weight() - (double) o1.price() / o1.weight()) * 100)));

        for (Item i : instanceItems) {
            if (currentWeight + i.weight() > instance.capacity()) {
                continue;
            }

            usedItems.set(i.id(), true);
            currentWeight += i.weight();
            currentPrice += i.price();
        }

        return new KnapSolution(instance.id(), instance.itemCount(), currentPrice,
                new ArrayList<Boolean>(usedItems));
    }
}
