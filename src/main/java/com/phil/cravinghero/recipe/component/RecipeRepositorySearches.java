package com.phil.cravinghero.recipe.component;

import com.phil.cravinghero.recipe.model.Ingredient;
import com.phil.cravinghero.recipe.model.Recipe;

import java.util.List;

interface RecipeRepositorySearches {
    List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients);
}
