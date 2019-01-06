package com.phil.mealshelper.configuration;

import com.phil.mealshelper.recipe.component.RecipeRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {RecipeRepository.class})
public class MongoConfiguration {
}
