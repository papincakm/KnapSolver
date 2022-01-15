package com.company.data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KnapSolution extends LineReader {
    final private int id;
    final private int itemCount;
    final private int bestPrice;
    final private List<Boolean> itemsUsed;

    public KnapSolution() {
        id = 0;
        itemCount = 0;
        bestPrice = 0;
        itemsUsed = null;
    }

    public KnapSolution(int id, int itemCount, int bestPrice, List<Boolean> itemsUsed) {
        this.id = id;
        this. itemCount = itemCount;
        this.bestPrice = bestPrice;
        this.itemsUsed = itemsUsed;
    }

    public int id() {
        return id;
    }

    public int itemCount() {
        return itemCount;
    }

    public int bestPrice() { return bestPrice; }

    public List<Boolean> itemsUsed() { return itemsUsed; }

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

    public KnapSolution read(String line) {
        try {
            StringTokenizer st = new StringTokenizer(line);
            int id = Math.abs(Integer.parseInt(st.nextToken())) - 1;
            int itemCount = Integer.parseInt(st.nextToken());
            int bestPrice = Integer.parseInt(st.nextToken());

            List<Boolean> itemUsedList = new ArrayList<Boolean>();
            for (int i = 0; i < itemCount; i++) {
                int candidate = Integer.parseInt(st.nextToken());
                if (candidate == 0)
                    itemUsedList.add(false);
                else
                    itemUsedList.add(true);
            }

            return new KnapSolution(id, itemCount, bestPrice, itemUsedList);
        } catch (Exception e) {
            System.out.println("KnapSolution - cant read line.");
            return new KnapSolution(1, 1, 1, new ArrayList<Boolean>());
        }
    }

    @Override
    public String toString() {
        return "KnapSolution{" +
                "id=" + id +
                ", itemCount=" + itemCount +
                ", bestPrice=" + bestPrice +
                ", itemsUsed=" + itemsUsed +
                '}';
    }
}
