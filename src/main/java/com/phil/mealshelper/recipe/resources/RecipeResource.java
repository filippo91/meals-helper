package com.phil.mealshelper.recipe.resources;

import com.phil.mealshelper.recipe.component.RecipeComponent;
import com.phil.mealshelper.recipe.model.Ingredient;
import com.phil.mealshelper.recipe.model.Recipe;
import com.phil.mealshelper.recipe.resources.dto.RecipeDto;
import com.phil.mealshelper.recipe.resources.mapper.RecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.phil.mealshelper.recipe.resources.mapper.RecipeMapper.recipetoRecipeDto;
import static com.phil.mealshelper.recipe.util.RecipeResourceUrls.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class RecipeResource {
    private RecipeComponent recipeComponent;

    @Autowired
    public RecipeResource(RecipeComponent recipeComponent) {
        this.recipeComponent = recipeComponent;
    }

    @GetMapping(RECIPE_FIND_ALL_URI)
    public List<RecipeDto> findAllRecipes() {
        return recipeComponent
                .findAllRecipes()
                .stream()
                .map(RecipeMapper::recipetoRecipeDto)
                .collect(Collectors.toList());
    }

    @GetMapping(RECIPE_FIND_BY_ID + "/{id}")
    public RecipeDto findRecipeById(@PathVariable String id) {
        return recipeComponent.findRecipeById(id)
                .map(RecipeMapper::recipetoRecipeDto)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Recipe Not Exist"));
    }

    @PostMapping(RECIPE_SEARCH_BY_INGREDIENTS_URI)
    public List<Recipe> findRecipesByIngredients(@RequestBody List<Ingredient> ingredients) {
        return recipeComponent.findRecipesByIngredients(ingredients);
    }

    @PostMapping(RECIPE_CREATE_URI)
    @ResponseStatus(CREATED)
    public RecipeDto storeRecipe(@RequestBody Recipe recipe){
        return recipetoRecipeDto(recipeComponent.storeRecipe(recipe));
    }
}
