package edu.estu.recipeapp.rest;

import edu.estu.recipeapp.entity.Recipe;
import edu.estu.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeRestController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/rest-recipes")
    public List<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

    @PostMapping("/rest-recipes")
    public Recipe postRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}
