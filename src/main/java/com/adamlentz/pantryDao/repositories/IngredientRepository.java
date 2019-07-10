package com.adamlentz.pantryDao.repositories;

import com.adamlentz.pantryDao.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    Ingredient findByName(String name);
}
