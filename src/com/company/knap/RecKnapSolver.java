package com.company.knap;

import com.company.data.KnapConfiguration;
import com.company.data.KnapInstance;
import com.company.data.KnapInstanceInterface;
import com.company.data.KnapSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecKnapSolver<T extends KnapInstanceInterface> extends KnapSolver<T> {
    protected final List<Integer> futurePrices;
    protected KnapSolution curBestSolution;

    public RecKnapSolver(T knapInstance) {
        super(knapInstance);
        futurePrices = countFuturePrices();
    }

    protected List<Integer> countFuturePrices() {
        List<Integer> futurePrices = new ArrayList<Integer>(Collections.nCopies(instance.itemCount(), 0));
        for (int i = instance.itemCount() - 2; i >= 0; i--) {
            futurePrices.set(i, instance.itemList().get(i).price() + futurePrices.get(i + 1));
        }
        return futurePrices;
    }

    protected Boolean solutionPossible(int position, KnapConfiguration configuration) {
        int possiblePrice = configuration.price() + futurePrices.get(position);
        return priceInSolutionOk(possiblePrice);
    }

    protected abstract Boolean priceInSolutionOk(int price);

    protected void setBestSolution(KnapConfiguration configuration) {
        curBestSolution = new KnapSolution(instance.id(), instance.itemCount(), configuration.price(),
                new ArrayList<Boolean>(configuration.usedItems()));
    }

    protected Boolean solutionFound(int price, int weight) {
        return (priceInSolutionOk(price) && weight <= instance.capacity());
    }

    protected Boolean evaluate(KnapConfiguration configuration) {
        if (solutionFound(configuration.price(), configuration.weight())) {
            setBestSolution(configuration);
            return true;
        } else {
            return false;
        }
    }
}
