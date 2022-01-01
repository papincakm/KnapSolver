package com.company.knap;

import com.company.data.DecKnapInstance;
import com.company.data.KnapSolution;
import com.company.data.KnapConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// KnapSolver for decision problem
public class DecKnapSolver extends RecKnapSolver<DecKnapInstance> {
    public DecKnapSolver(DecKnapInstance knapInstance){
        super(knapInstance);
    }

    protected Boolean recSolve(int position, KnapConfiguration configuration) {
        if (position == instance.itemCount())
            return evaluate(configuration);

        // check wheter further calculation is needed
        if (!solutionPossible(position, configuration))
            return false;

        configuration.usedItems().set(position, false);
        // call branch without adding item, dont continue if solution was found
        if (recSolve(position + 1, configuration))
            return true;

        configuration = new KnapConfiguration(configuration.price() + instance.itemList().get(position).price(),
                configuration.weight() + instance.itemList().get(position).weight(),
                new ArrayList<Boolean>(configuration.usedItems()));
        configuration.usedItems().set(position, true);

        return recSolve(position + 1, configuration);
    }

    @Override
    protected Boolean priceInSolutionOk(int price) {
        return (price >= instance.minPrice());
    };
}
