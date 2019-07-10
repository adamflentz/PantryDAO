package com.adamlentz.pantryDao.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer recipe_id;

    @NotNull
    private String user;

    @NotEmpty
    @OneToMany(mappedBy = "id")
    private List<DirectionIngredient> directionIngredientList;

    @NotEmpty
    @OneToMany(mappedBy = "id")
    private List<Direction> recipeDetails;

    @NotNull
    private boolean publicRecipe;

    @Max(5)
    private float rating;

    @NotNull
    private LocalDateTime dateCreated;
}
