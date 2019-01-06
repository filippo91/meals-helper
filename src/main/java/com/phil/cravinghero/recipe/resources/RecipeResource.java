package com.phil.cravinghero.recipe.resources;

import com.phil.cravinghero.recipe.component.RecipeComponent;
import com.phil.cravinghero.recipe.model.Ingredient;
import com.phil.cravinghero.recipe.model.Recipe;
import com.phil.cravinghero.recipe.resources.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

import static com.phil.cravinghero.recipe.util.RecipeResourceUrls.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class RecipeResource {
    private RecipeComponent recipeComponent;

    @Autowired
    public RecipeResource(RecipeComponent recipeComponent) {
        this.recipeComponent = recipeComponent;
    }

    @GetMapping(RECIPE_FIND_ALL_URI)
    public List<RecipeDto> findAllRecipes() {

        List<RecipeDto> allRecipes = recipeComponent
                .findAllRecipes()
                .stream()
                .map(recipe -> {
                    System.out.println(recipe);
                    RecipeDto recipeDto = new RecipeDto(recipe);
                    recipeDto.add(linkTo(methodOn(RecipeResource.class).findRecipeById(recipe.getId())).withSelfRel());
                    return recipeDto;
                })
                .collect(Collectors.toList());

        return allRecipes;
    }

    @GetMapping(RECIPE_FIND_BY_ID + "/{id}")
    public RecipeDto findRecipeById(@PathVariable String id) {
        return recipeComponent.findRecipeById(id)
                .map(recipe -> {
                    System.out.println(recipe);
                    RecipeDto recipeDto = new RecipeDto(recipe);
                    recipeDto.add(linkTo(methodOn(RecipeResource.class).findRecipeById(recipe.getId())).withSelfRel());
                    return recipeDto;})
                .orElseThrow(() -> new HttpClientErrorException(BAD_REQUEST));

    }

    @PostMapping(RECIPE_SEARCH_BY_INGREDIENTS_URI)
    public List<Recipe> findRecipesByIngredients(@RequestBody List<Ingredient> ingredients) {
        return recipeComponent.findRecipesByIngredients(ingredients);
    }

    @PostMapping(RECIPE_CREATE_URI)
    @ResponseStatus(CREATED)
    public Recipe storeRecipe(@RequestBody Recipe recipe){
        return recipeComponent.storeRecipe(recipe);
    }
}
