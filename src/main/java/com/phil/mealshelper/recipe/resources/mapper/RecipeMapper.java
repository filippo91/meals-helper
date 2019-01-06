package com.phil.mealshelper.recipe.resources.mapper;

import com.phil.mealshelper.recipe.model.Recipe;
import com.phil.mealshelper.recipe.resources.RecipeResource;
import com.phil.mealshelper.recipe.resources.dto.RecipeDto;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public final class RecipeMapper {
    public static RecipeDto recipetoRecipeDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto(recipe);
        recipeDto.add(linkTo(methodOn(RecipeResource.class).findRecipeById(recipe.getId())).withSelfRel());
        return recipeDto;
    }
}
