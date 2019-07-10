package com.adamlentz.pantryDao.payloads;

import com.adamlentz.pantryDao.entities.Ingredient;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
public class CreatePantryRequest {

    @NotBlank
    private String pantryName;

    private Boolean isPrimary;

    List<Ingredient> ingredientList;
}
