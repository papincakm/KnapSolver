package com.company.io;

import com.company.data.DecKnapInstance;
import com.company.data.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DecKnapInstanceEditor extends FileEditor<DecKnapInstance> {
    protected DecKnapInstance read(String line) {
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
