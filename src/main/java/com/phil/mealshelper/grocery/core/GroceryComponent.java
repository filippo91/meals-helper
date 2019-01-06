package com.phil.mealshelper.grocery.core;

import com.phil.mealshelper.grocery.model.GroceryList;
import com.phil.mealshelper.grocery.model.GroceryListItem;

public interface GroceryComponent {
    GroceryList storeGroceryList(GroceryListItem groceryListItem);
    GroceryList addItemToGroceryList(GroceryListItem groceryListItem);
    GroceryList markGroceryListAsDone();
}
