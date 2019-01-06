package com.phil.cravinghero.recipe.component;

import com.phil.cravinghero.recipe.model.Ingredient;
import com.phil.cravinghero.recipe.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

class RecipeRepositorySearchesImpl implements RecipeRepositorySearches {
    private MongoTemplate mongoTemplate;

    @Autowired
    public RecipeRepositorySearchesImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients) {
//        ProjectionOperation.ProjectionOperationBuilder projectionStage = Aggregation.project()
//                .and(SetOperators.SetIsSubset.arrayAsSet("ingredients").isSubsetOf());
//        AggregationExpression
//        MatchOperation matchStage = Aggregation.match(new Criteria("isSubset").is(true));
//        Aggregation aggregation = Aggregation.newAggregation(matchStage, projectionStage);
//        AggregationResults<Recipe> aggregate = mongoTemplate.aggregate(aggregation, "recipes", Recipe.class);

        return mongoTemplate.find(Query.query(Criteria.where("ingredients").all(ingredients)), Recipe.class);
    }
}
