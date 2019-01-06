package com.phil.cravinghero.recipe.resources.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.phil.cravinghero.recipe.model.Recipe;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class RecipeDto extends ResourceSupport {
    private Recipe recipe;

    @JsonCreator
    public RecipeDto(@JsonProperty("content") Recipe recipe) {
        this.recipe = recipe;
    }
}
