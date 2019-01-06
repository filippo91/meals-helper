package com.phil.mealshelper.recipe.component;

import com.phil.mealshelper.recipe.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String>, RecipeRepositorySearches {
}
