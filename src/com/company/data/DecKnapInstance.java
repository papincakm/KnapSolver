package com.company.data;

import java.util.List;

public record DecKnapInstance(int id, int itemCount, int capacity, int minPrice, List<Item> itemList)
        implements KnapInstanceInterface{
}
