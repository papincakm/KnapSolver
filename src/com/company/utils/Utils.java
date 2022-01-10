package com.company.utils;

import com.company.data.Item;
import com.company.data.KnapSolution;

import java.util.List;

public class Utils {
    public static double countRelativeError(KnapSolution computedSolution, KnapSolution providedSolution) {
        if (Math.max(providedSolution.bestPrice(), computedSolution.bestPrice()) == 0)
            return 0;
        return Math.abs((double) (computedSolution.bestPrice() - providedSolution.bestPrice()) /
                Math.max(providedSolution.bestPrice(), computedSolution.bestPrice()));
    }

    //TODO: find a better way without using this function
    public static int getMaxPricedId(List<Item> itemList) {
        int maxId = 0;
        for (Item i : itemList) {
            if (i.price() > itemList.get(maxId).price())
                maxId = i.id();
        }
        return maxId;
    }
}
