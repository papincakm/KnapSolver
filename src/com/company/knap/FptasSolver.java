package com.company.knap;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;
import com.company.utils.Utils;

public class FptasSolver extends DynamicSolver {
    private KnapInstance fptasInstance;
    private double allowedError;

    FptasSolver(KnapInstance knapInstance, double error) {
        super(knapInstance);
        allowedError = allowedError;
    }

    @Override
    public KnapSolution solve() {
        return null;
    }

    // get instance with recalculated prices for fptas algorithm
    private KnapInstance getFptasInstance() {
        int maxPrice = instance.itemList().get(Utils.getMaxPricedId(instance.itemList())).price();
        double kValue = allowedError * maxPrice / instance.itemCount();
        System.out.println("kvalue " + kValue);
        return null;
    }
}
