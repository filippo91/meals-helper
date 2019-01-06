package com.phil.mealshelper.grocery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GroceryList {
    List<GroceryListItem> groceryListItems;
}
