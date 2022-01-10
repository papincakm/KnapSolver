package com.company.data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KnapInstance extends LineReader {
    private final int id;
    private final int itemCount;
    private final int capacity;
    private final List<Item> itemList;

    public KnapInstance() {
        id = 0;
        itemCount = 0;
        capacity = 0;
        itemList = null;
    }

    KnapInstance(int id, int itemCount, int capacity, List<Item> itemList) {
        this.id = id;
        this.itemCount = itemCount;
        this.capacity = capacity;
        this.itemList = itemList;
    }

    public int id() {
        return id;
    }

    public int itemCount() {
        return itemCount;
    }

    public int capacity() {
        return capacity;
    }

    public List<Item> itemList() {
        return itemList;
    }

    public KnapInstance read(String line) {
        try {
            StringTokenizer st = new StringTokenizer(line);
            int id = Math.abs(Integer.parseInt(st.nextToken())) - 1;
            int itemCount = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            List<Item> itemList = new ArrayList<Item>();
            for (int i = 0; i < itemCount; i++) {
                itemList.add(new Item(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            return new KnapInstance(id, itemCount, capacity, itemList);
        } catch (Exception e) {
            System.out.println("KnapInstance- cant read line.");
            return new KnapInstance(1, 1, 1, new ArrayList<Item>());
        }
    }
}
