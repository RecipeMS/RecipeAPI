package edu.estu.recipeapp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    private Long id;
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private int size;

    private List<Category> categories;

    private List<Tag> tags;

    public Recipe(String name, String description, List<Ingredient> ingredients, int size, List<Category> categories, List<Tag> tags) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.size = size;
        this.categories = categories;
        this.tags = tags;
    }
}

