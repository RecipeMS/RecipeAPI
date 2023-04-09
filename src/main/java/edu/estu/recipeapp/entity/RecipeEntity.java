package edu.estu.recipeapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class RecipeEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<IngredientEntity> ingredients;
    private int size;

    private List<Category> categories;

    private List<Tag> tags;

    public RecipeEntity(String name, String description, List<IngredientEntity> ingredients, int size, List<Category> categories, List<Tag> tags) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.size = size;
        this.categories = categories;
        this.tags = tags;
    }
}

