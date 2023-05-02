package edu.estu.recipeapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private int size;

    @OneToMany
    private final List<IngredientEntity> ingredients = new LinkedList<>();

    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    private final Set<Category> categories = new HashSet<>(3);

    @ElementCollection(targetClass = Tag.class)
    @Enumerated(EnumType.STRING)
    private final Set<Tag> tags = new HashSet<>(3);

    public RecipeEntity(String name, String description, int size) {
        this.name = name;
        this.description = description;
        this.size = size;

    }

    public void addIngredient(IngredientEntity ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void removeIngredient(IngredientEntity ingredient) {
        this.ingredients.remove(ingredient);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }
}

