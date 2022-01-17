package com.company.knap;

import com.company.data.Item;
import com.company.data.KnapInstance;
import com.company.data.KnapSolution;

import java.util.List;
import java.util.ArrayList;

public class FptasSolver extends KnapSolver {
    private double allowedError;

    public FptasSolver(double error) {
        allowedError = error;
    }

    @Override
    public KnapSolution solve(KnapInstance instance) {
        this.instance = instance;
        KnapInstance fptasInstance = getFptasInstance(instance);
        KnapSolution fptasSolution = new DynamicSolver().solve(fptasInstance);
        return fptasSolToKnap(fptasSolution);
    }

    // get instance with recalculated prices for fptas algorithm
    private KnapInstance getFptasInstance(KnapInstance instance) {
        int maxPrice = instance.getMaxPricedItem().price();
        double kValue = Math.max(allowedError * maxPrice / instance.itemCount(), 1);
        List<Item> fptasItems = new ArrayList<Item>();

        instance.itemList().forEach( (i) -> {
            fptasItems.add( new Item( i.id(), i.weight(), (int) (i.price() / kValue)));
        } );

        return new KnapInstance(instance.id(), instance.itemCount(), instance.capacity(), fptasItems);
    }

    private KnapSolution fptasSolToKnap(KnapSolution fptasSolution) {
        int price = 0;
        for (Item i : instance.itemList()) {
            if (fptasSolution.itemsUsed().get(i.id())) {
                price += i.price();
            }
        }

        return new KnapSolution(fptasSolution.id(), fptasSolution.itemCount(), price, fptasSolution.itemsUsed());
    }
}
