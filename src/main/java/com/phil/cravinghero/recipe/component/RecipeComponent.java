package com.phil.cravinghero.recipe.component;

import com.phil.cravinghero.recipe.model.Ingredient;
import com.phil.cravinghero.recipe.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeComponent {
    List<Recipe> findAllRecipes();

    Recipe storeRecipe(Recipe recipe);

    List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients);

    Optional<Recipe> findRecipeById(String id);
}
