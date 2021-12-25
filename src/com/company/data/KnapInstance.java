package com.company.data;

import java.util.List;

public record KnapInstance(int id, int itemCount, int capacity, List<Item> itemList) implements  KnapInstanceInterface {
}
