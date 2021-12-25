package com.company.knap;

import com.company.data.KnapConfiguration;
import com.company.data.KnapInstance;
import com.company.data.KnapSolution;

import java.util.ArrayList;
import java.util.Collections;

public class ConKnapSolver extends RecKnapSolver<KnapInstance> {
    public ConKnapSolver(KnapInstance knapInstance){
        super(knapInstance);
    }

    public KnapSolution solve() {
        //TODO: implement
        recSolve(0, new KnapConfiguration(0, 0,
                new ArrayList<Boolean>(Collections.nCopies(instance.itemCount(), false))));
        return curBestSolution;
    }

    private Boolean recSolve(int position, KnapConfiguration configuration) {
        if (position == instance.itemCount())
            return evaluate(configuration);

        // check wheter further calculation is needed
        if (!solutionPossible(position, configuration))
            return false;

        configuration.usedItems().set(position, false);
        // call branch without adding item, dont continue if solution was found
        recSolve(position + 1, configuration);

        configuration = new KnapConfiguration(configuration.price() + instance.itemList().get(position).price(),
                configuration.weight() + instance.itemList().get(position).weight(),
                new ArrayList<Boolean>(configuration.usedItems()));
        configuration.usedItems().set(position, true);

        return recSolve(position + 1, configuration);
    }

    @Override
    protected Boolean priceInSolutionOk(int price) {
        return (price > curBestSolution.bestPrice());
    };
}
