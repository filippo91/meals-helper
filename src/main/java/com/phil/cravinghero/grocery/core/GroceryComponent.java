package com.phil.cravinghero.grocery.core;

import com.phil.cravinghero.grocery.model.GroceryList;
import com.phil.cravinghero.grocery.model.GroceryListItem;

public interface GroceryComponent {
    GroceryList storeGroceryList(GroceryListItem groceryListItem);
    GroceryList addItemToGroceryList(GroceryListItem groceryListItem);
    GroceryList markGroceryListAsDone();
}
