package com.company.data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KnapInstanceW extends DataFileWrapper<KnapInstance> {
    public KnapInstance read(String line) {
        try {
            StringTokenizer st = new StringTokenizer(line);
            int id = Math.abs(Integer.parseInt(st.nextToken())) - 1;
            int itemCount = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            List<Item> itemList = new ArrayList<Item>();
            for (int i = 0; i < itemCount; i++) {
                itemList.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            return new KnapInstance(id, itemCount, capacity, itemList);
        } catch (Exception e) {
            System.out.println("DecKnapInstanceW - cant read line.");
            return new KnapInstance(1, 1, 1, new ArrayList<Item>());
        }
    }
}
