var oilIngredient = {
    "gtin": "1"
};

var codIngredient = {
    "gtin": "2"
};

var tomatoSauceIngredient = {
    "gtin": "3"
};

var besciamellaIngredient = {
    "gtin": "4"
};

var lasagnaRecipe = {
    "ingredients": [tomatoSauceIngredient, besciamellaIngredient],
    "cookingSteps": [],
    "duration": 90,
    "difficulty": "HARD"
};

var fishAndChipsRecipe = {
    "ingredients": [oilIngredient, codIngredient],
    "cookingSteps": [],
    "duration": 30,
    "difficulty": "HARD"
};

var recipeCollection = db.getCollection('recipe');

recipeCollection.insert([lasagnaRecipe, fishAndChipsRecipe]);