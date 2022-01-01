package com.company.data;

import java.util.List;

public record KnapSolution(int id, int itemCount, int bestPrice, List<Boolean> itemsUsed) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnapSolution that = (KnapSolution) o;
        return id == that.id && itemCount == that.itemCount && bestPrice == that.bestPrice;
    }

    public boolean equalsAsDecisionProblem(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnapSolution that = (KnapSolution) o;
        return id == that.id && itemCount == that.itemCount &&
                ((bestPrice > 0 && that.bestPrice > 0) || (bestPrice == 0 && that.bestPrice == 0));
    }
}
