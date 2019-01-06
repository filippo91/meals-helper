package com.phil.mealshelper.recipe.component;

import com.phil.mealshelper.recipe.model.Ingredient;
import com.phil.mealshelper.recipe.model.Recipe;

import java.util.List;

interface RecipeRepositorySearches {
    List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients);
}
