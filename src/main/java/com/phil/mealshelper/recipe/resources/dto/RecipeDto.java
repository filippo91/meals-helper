package com.phil.mealshelper.recipe.resources.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.phil.mealshelper.recipe.model.Recipe;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeDto extends ResourceSupport {
    private Recipe recipe;

    @JsonCreator
    public RecipeDto(@JsonProperty("content") Recipe recipe) {
        this.recipe = recipe;
    }
}
