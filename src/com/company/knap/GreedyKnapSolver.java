package com.company.knap;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;

import java.util.ArrayList;
import java.util.Collections;

public class GreedyKnapSolver extends KnapSolver<KnapInstance>{
    protected KnapSolution curBestSolution;

    public GreedyKnapSolver(KnapInstance knapInstance) {
        super(knapInstance);
        curBestSolution = new KnapSolution(instance.id(), instance.itemCount(), 0,
                new ArrayList<Boolean>(Collections.nCopies(instance.itemCount(), false)));
    }

    public KnapSolution solve() {
        int currentWeight = 0;
        int currentPrice = 0;

        instance.itemList().sort((o1, o2) ->
                (int) (Math.ceil(((double) o2.price() / o2.weight() - (double) o1.price() / o1.weight()) * 100)));

        return curBestSolution;
    }
}
