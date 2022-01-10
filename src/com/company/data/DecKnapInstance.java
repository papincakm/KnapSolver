package com.company.data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DecKnapInstance extends KnapInstance {
    private final int minPrice;

    public DecKnapInstance() {
        super();
        minPrice = 0;
    }

    DecKnapInstance(int id, int itemCount, int capacity, int minPrice, List<Item> itemList) {
        super(id, itemCount, capacity, itemList);
        this.minPrice = minPrice;
    }

    public int minPrice() {
        return minPrice;
    }

    public DecKnapInstance read(String line) {
        try {
            StringTokenizer st = new StringTokenizer(line);
            int id = Math.abs(Integer.parseInt(st.nextToken())) - 1;
            int itemCount = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());
            int minPrice = Integer.parseInt(st.nextToken());

            List<Item> itemList = new ArrayList<Item>();
            for (int i = 0; i < itemCount; i++) {
                itemList.add(new Item(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            return new DecKnapInstance(id, itemCount, capacity, minPrice, itemList);
        } catch (Exception e) {
            System.out.println("DecKnapInstance - cant read line.");
            return new DecKnapInstance(1, 1, 1, 1, new ArrayList<Item>());
        }
    }
}
