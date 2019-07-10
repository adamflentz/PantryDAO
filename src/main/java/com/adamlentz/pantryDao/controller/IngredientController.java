package com.adamlentz.pantryDao.controller;

import com.adamlentz.pantryDao.entities.Ingredient;
import com.adamlentz.pantryDao.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(final IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Ingredient> getAllRecipes() {
        // This returns a JSON or XML with the users
        return ingredientRepository.findAll();
    }

    @PostMapping(path = "/create")
    public @ResponseBody
    Integer createIngredient(Ingredient ingredient) {
        Ingredient endIngredient = ingredientRepository.save(ingredient);
        return endIngredient.getName();
    }
}