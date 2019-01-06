package com.phil.cravinghero.configuration;

import com.phil.cravinghero.recipe.component.RecipeRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {RecipeRepository.class})
public class MongoConfiguration {
}
