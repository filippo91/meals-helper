package com.phil.mealshelper.grocery.core;

import com.phil.mealshelper.grocery.model.GroceryList;
import com.phil.mealshelper.grocery.model.GroceryListItem;

public interface GroceryComponent {
    GroceryList storeGroceryList(GroceryList groceryList);
    GroceryList addItemToGroceryList(String groceryListId, GroceryListItem groceryListItem);
    GroceryList markGroceryAsDone(String groceryListId);
}
