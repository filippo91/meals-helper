package com.phil.cravinghero.grocery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GroceryList {
    List<GroceryListItem> groceryListItems;
}
