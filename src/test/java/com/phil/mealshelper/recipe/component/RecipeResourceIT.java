package com.phil.mealshelper.recipe.component;

import com.phil.mealshelper.recipe.model.Ingredient;
import com.phil.mealshelper.recipe.model.Recipe;
import com.phil.mealshelper.recipe.resources.dto.RecipeDto;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.script.ExecutableMongoScript;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static com.phil.mealshelper.recipe.util.RecipeResourceUrls.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "default")
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RecipeResourceIT {
    @LocalServerPort
    private int randomServerPort;
    @Autowired
    private RecipeRepository recipeRepository;
    private String domainAndPort;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findAllRecipes_returnsAllAvailableRecords() {
        when()
                .get(domainAndPort + RECIPE_FIND_ALL_URI)
                .then()
                .statusCode(200)
                .body("recipe", notNullValue())
                .body("recipe", hasSize(2))
                .body("links", hasSize(2))
                .extract()
                .as(RecipeDto[].class);

        //TODO: look into json schema validation
    }

    @Test
    public void findAllRecipesByIngredients() {
        Ingredient oilIngredient = new Ingredient("1");
        Ingredient codIngredient = new Ingredient("2");

        given()
                .contentType(ContentType.JSON)
                .body(asList(oilIngredient, codIngredient))
                .when()
                .post(domainAndPort + RECIPE_SEARCH_BY_INGREDIENTS_URI)
                .then()
                .statusCode(200)
                .body("", notNullValue())
                .body("", hasSize(1));
    }

    @Test
    public void storeRecipe_persistsRecipe() {
        Ingredient ingredient = new Ingredient(UUID.randomUUID().toString());
        Recipe theRecipe = new Recipe(null, asList(ingredient), null, 1, Recipe.Difficulty.EASY);

        RecipeDto recipeDto = given()
                .contentType(ContentType.JSON)
                .body(theRecipe)
                .when()
                .post(domainAndPort + RECIPE_CREATE_URI)
                .then()
                .statusCode(201)
                .body("", notNullValue())
//                .body("recipe.id", notNullValue())
                .extract()
                .body().as(RecipeDto.class);

        Recipe storedRecipe = recipeDto.getRecipe();
        Recipe lookupRecipe = mongoTemplate.findById(storedRecipe.getId(), Recipe.class);
        assertThat(lookupRecipe, equalTo(storedRecipe));
    }

    @Before
    public void setup() throws IOException, URISyntaxException {
        domainAndPort = "http://localhost:" + randomServerPort;
        deleteTestData();
        loadTestData("recipe_test_data_script.js");
    }

    private void loadTestData(String scriptName) throws URISyntaxException, IOException {
        URL resourceUrl = Thread.currentThread().getContextClassLoader().getResource(scriptName);
        Path resourcePath = Paths.get(resourceUrl.toURI());
        final String script = "function() {\n" +
                new String(Files.readAllBytes(resourcePath), Charset.forName("UTF-8")) + "\n" +
                "}\n";
        final ExecutableMongoScript migrationScript = new ExecutableMongoScript(script);
        final ScriptOperations scriptOps = mongoTemplate.scriptOps();
        scriptOps.execute(migrationScript);
    }

    private void deleteTestData() {
        mongoTemplate.dropCollection("recipe");
    }
}