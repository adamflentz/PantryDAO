package com.adamlentz.pantryDao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer name;

    @NotEmpty
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ingredient_substitute", joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COLLEAGUE_ID")})
    private List<Ingredient> substitutes;
}