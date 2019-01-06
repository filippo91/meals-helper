package com.phil.mealshelper.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeItem {
    private Ingredient ingredient;
    private Quantity quantity;
}
