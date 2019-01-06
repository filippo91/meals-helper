package com.phil.cravinghero.recipe.component;

import com.phil.cravinghero.recipe.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String>, RecipeRepositorySearches {
}
