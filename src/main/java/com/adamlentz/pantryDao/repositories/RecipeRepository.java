package com.adamlentz.pantryDao.repositories;
import com.adamlentz.pantryDao.entities.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    Set<Recipe> findByPublicRecipeAndRatingGreaterThanEqualAndDateCreatedOrderByRatingDesc(boolean isPublic, int rating, LocalDateTime date);
}
