package edu.estu.recipeapp.service;

import edu.estu.recipeapp.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private List<Recipe> recipes;

    public RecipeService() {
        recipes = new ArrayList<>();
    }

    public List<Recipe> createRecipes() {

        Ingredient flour = new Ingredient("flour", 1, Unit.CUP);
        Ingredient sugar = new Ingredient("sugar", 1, Unit.CUP);
        Ingredient butter = new Ingredient("butter", 1.5, Unit.CUP);
        Ingredient eggs = new Ingredient("eggs", 2, Unit.COUNT);

        List<Category> categories = List.of(Category.DESSERT);
        List<Tag> tags = List.of(Tag.VEGETARIAN, Tag.VEGAN);

        Recipe cake = new Recipe("Cake", "A delicious cake", List.of(flour, sugar, butter, eggs), 4, categories, tags);
        recipes.add(cake);

        Ingredient milk = new Ingredient("milk", 1, Unit.CUP);
        Ingredient cocoa = new Ingredient("cocoa", 1, Unit.CUP);
        Ingredient vanilla = new Ingredient("vanilla", 1, Unit.TEASPOON);

        Recipe brownie = new Recipe("Brownie", "A delicious brownie", List.of(flour, sugar, butter, eggs, milk, cocoa, vanilla), 4, categories, tags);
        recipes.add(brownie);

        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}
