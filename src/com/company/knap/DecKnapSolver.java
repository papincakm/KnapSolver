package com.company.knap;

import com.company.data.DecKnapInstance;
import com.company.data.ConKnapSolution;
import com.company.data.KnapConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecKnapSolver extends KnapSolver<DecKnapInstance, ConKnapSolution> {
    private final List<Integer> futurePrices;
    private ConKnapSolution curBestSolution;

    public DecKnapSolver(DecKnapInstance knapInstance){
        super(knapInstance);
        futurePrices = countFuturePrices();
    }

    public ConKnapSolution solve() {
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
        if (recSolve(position + 1, configuration))
            return true;

        configuration = new KnapConfiguration(configuration.price() + instance.itemList().get(position).price(),
                configuration.weight() + instance.itemList().get(position).weight(),
                new ArrayList<Boolean>(configuration.usedItems()));
        configuration.usedItems().set(position, true);

        return recSolve(position + 1, configuration);
    }

    private List<Integer> countFuturePrices() {
        List<Integer> futurePrices = new ArrayList<Integer>(Collections.nCopies(instance.itemCount(), 0));
        for (int i = instance.itemCount() - 1; i >= 0; i--) {
            futurePrices.set(i, instance.itemList().get(i).price() + futurePrices.get(i + 1));
        }
        return futurePrices;
    }

    //TODO: mby add this method to KnapConfiguration
    private Boolean solutionPossible(int position, KnapConfiguration configuration) {
        int possiblePrice = configuration.price() + futurePrices.get(position);
        if (possiblePrice < instance.minPrice())
            return false;
        return true;
    }

    private Boolean solutionFound(int price, int weight) {
        return (price >= instance.minPrice() && weight <= instance.capacity());
    }

    //TODO: mby move to super class
    private void setBestSolution(KnapConfiguration configuration) {
        curBestSolution = new ConKnapSolution(instance.id(), instance.itemCount(), configuration.price(),
                new ArrayList<Boolean>(configuration.usedItems()));
    }

    private Boolean evaluate(KnapConfiguration configuration) {
        if (solutionFound(configuration.price(), configuration.weight())) {
            setBestSolution(configuration);
            return true;
        } else {
            return false;
        }
    }
}
