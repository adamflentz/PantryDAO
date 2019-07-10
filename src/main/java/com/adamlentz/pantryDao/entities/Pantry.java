package com.adamlentz.pantryDao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pantry")
public class Pantry implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer pantryId;

    private String userName;

    @NotBlank
    private String pantryName;

    @OneToMany(mappedBy = "id")
    private List<Ingredient> ingredientList;

    private boolean primaryPantry;


}
