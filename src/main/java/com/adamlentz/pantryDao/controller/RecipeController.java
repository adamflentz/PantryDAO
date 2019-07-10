package com.adamlentz.pantryDao.controller;

import com.adamlentz.pantryDao.entities.Recipe;
import com.adamlentz.pantryDao.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Value("${featuredrecipe.ratingthreshold}")
    public static final int RATING_THRESHOLD = 4;

    @Value("${featuredrecipe.daythreshold}")
    public static final int DAY_THRESHOLD = 1;

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(final RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Recipe> getAllRecipes() {
        // This returns a JSON or XML with the users
        return recipeRepository.findAll();
    }

    @PostMapping(path = "/create")
    public @ResponseBody
    Integer createRecipe(Recipe recipe) {
        Recipe endRecipe = recipeRepository.save(recipe);
        return endRecipe.getRecipe_id();
    }

    @GetMapping(path = "/popular")
    public Iterable<Recipe> getPopularRecipes() {
        return recipeRepository.findByPublicRecipeAndRatingGreaterThanEqualAndDateCreatedOrderByRatingDesc(
                true, RATING_THRESHOLD, LocalDateTime.now().minusDays(DAY_THRESHOLD));
    }
}