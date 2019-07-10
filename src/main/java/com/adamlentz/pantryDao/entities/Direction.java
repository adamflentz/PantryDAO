package com.adamlentz.pantryDao.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "recipe_direction")
public class Direction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private Integer step;

    @NotEmpty
    private String description;
}
