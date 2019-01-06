package com.phil.mealshelper.recipe.component;

import com.phil.mealshelper.recipe.model.Ingredient;
import com.phil.mealshelper.recipe.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class RecipeComponentImpl implements RecipeComponent {
    private RecipeRepository recipeRepository;

    @Autowired
    RecipeComponentImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe storeRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients) {
        return recipeRepository.findRecipesByIngredients(ingredients);
    }

    @Override
    public Optional<Recipe> findRecipeById(String id) {
        return recipeRepository.findById(id);
    }
}
