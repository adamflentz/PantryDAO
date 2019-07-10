package com.adamlentz.pantryDao.repositories;

import com.adamlentz.pantryDao.entities.Pantry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface PantryRepository extends CrudRepository<Pantry, Integer> {
    Set<Pantry> findByUserName(String userName);
}
