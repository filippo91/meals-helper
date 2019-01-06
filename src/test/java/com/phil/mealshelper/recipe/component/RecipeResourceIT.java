package com.phil.mealshelper.recipe.component;

import com.phil.mealshelper.recipe.model.Ingredient;
import com.phil.mealshelper.recipe.model.Recipe;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static com.phil.mealshelper.recipe.util.RecipeResourceUrls.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class RecipeResourceIT {
    @LocalServerPort
    private int randomServerPort;

    @Autowired
    private RecipeRepository recipeRepository;

    private String domainAndPort;

    @Before
    public void setup(){
        domainAndPort = "http://localhost:" + randomServerPort;
    }

    @Test
    public void findAllRecipes() {
        //given
        recipeRepository.save(new Recipe(null, null, null, null, Recipe.Difficulty.EASY));

        RestAssured
                .when()
                    .get( domainAndPort + RECIPE_FIND_ALL_URI)
                .then()
                    .statusCode(200)
                    .body("", notNullValue())
                    .body("", is(not(empty())));
    }

    @Test
    @Ignore("setup database before tests")
    public void findAllRecipesByIngredients() {
        Ingredient ingredient = new Ingredient("e3a25512-75d6-42a6-9331-24d46789124c");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(asList(ingredient))
                .when()
                .post(domainAndPort + RECIPE_SEARCH_BY_INGREDIENTS_URI)
                .then()
                .statusCode(200)
                .body("", notNullValue())
                .body("", hasSize(1));
    }

    @Test
    public void storeRecipe() {
        Ingredient ingredient = new Ingredient(UUID.randomUUID().toString());
        Recipe theRecipe = new Recipe(null, asList(ingredient), null, 1, Recipe.Difficulty.EASY);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(theRecipe)
                .when()
                .post(domainAndPort + RECIPE_CREATE_URI)
                .then()
                .statusCode(201)
                .body("", notNullValue())
                .body("id", notNullValue());
    }
}