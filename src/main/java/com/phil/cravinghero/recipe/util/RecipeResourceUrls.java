package com.phil.cravinghero.recipe.util;

import static com.phil.cravinghero.common.util.ApplicationApiUris.APPLICATION_API_ROOT;

public final class RecipeResourceUrls {
    public static final String RECIPE_ROOT_URI = APPLICATION_API_ROOT + "/recipes";
    public static final String RECIPE_CREATE_URI = RECIPE_ROOT_URI;
    public static final String RECIPE_FIND_ALL_URI = RECIPE_ROOT_URI;
    public static final String RECIPE_SEARCH_BY_INGREDIENTS_URI = RECIPE_ROOT_URI + "/search-by-ingredients";
    public static final String RECIPE_FIND_BY_ID = RECIPE_ROOT_URI;
}
