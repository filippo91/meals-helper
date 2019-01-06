package com.phil.mealshelper.foodsupply.core;

import com.phil.mealshelper.foodsupply.model.FoodSupplyItem;

public interface FoodSupplyComponent {
    FoodSupplyItem addItemToFoodSupply(String foodSupplyId, FoodSupplyItem foodSupplyItem);
    FoodSupplyItem updateItemInFoodSupply(String foodSupplyId, FoodSupplyItem foodSupplyItem);
}
