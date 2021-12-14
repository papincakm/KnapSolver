package com.company.data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DecKnapInstanceW extends DataFileWrapper<DecKnapInstance> {
    public DecKnapInstance read(String line) {
        try {
            StringTokenizer st = new StringTokenizer(line);
            int id = Integer.parseInt(st.nextToken());
            int itemCount = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());
            int minPrice = Integer.parseInt(st.nextToken());

            List<Item> itemList = new ArrayList<Item>();
            for (int i = 0; i < itemCount; i++) {
                itemList.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            return new DecKnapInstance(id, itemCount, capacity, minPrice, itemList);
        } catch (Exception e) {
            System.out.println("DecKnapInstanceW - cant read line.");
            return new DecKnapInstance(1, 1, 1, 1, new ArrayList<Item>());
        }
    }
}
