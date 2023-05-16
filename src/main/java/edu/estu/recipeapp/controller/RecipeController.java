package edu.estu.recipeapp.controller;

import edu.estu.recipeapp.entity.Category;
import edu.estu.recipeapp.entity.IngredientEntity;
import edu.estu.recipeapp.entity.RecipeEntity;
import edu.estu.recipeapp.entity.Tag;
import edu.estu.recipeapp.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController()
@RequestMapping("/recipes")
public class RecipeController {
    RecipeRepository recipeRepository;
    IngredientController ingredientController;

    public RecipeController(RecipeRepository recipeRepository, IngredientController ingredientController) {
        this.recipeRepository = recipeRepository;
        this.ingredientController = ingredientController;
    }

    @GetMapping
    public Iterable<RecipeEntity> getRecipes() {
        return recipeRepository.findAll();
    }

    @PostMapping
    public RecipeEntity createRecipe(@RequestBody RecipeEntity recipe) {
        List<IngredientEntity> ingredients = recipe.getIngredients();

        for (IngredientEntity ingredient : ingredients) {
            ingredientController.createIngredient(ingredient);
        }

        return recipeRepository.save(recipe);

    }


    @GetMapping("/{recipeId}")
    public RecipeEntity getRecipe(@PathVariable Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @PutMapping("/{recipeId}")
    public RecipeEntity updateRecipe(@PathVariable Long recipeId,@RequestBody RecipeEntity recipe) {
        Optional<RecipeEntity> recipeOptional = recipeRepository.findById(recipeId);
        if (recipeOptional.isPresent()) {
            RecipeEntity recipeEntity = recipeOptional.get();
            recipeEntity.setName(recipe.getName());
            recipeEntity.setDescription(recipe.getDescription());
            recipeEntity.setSize(recipe.getSize());
            recipeEntity.setIngredients(recipe.getIngredients());
            recipeEntity.setTags(recipe.getTags());
            recipeEntity.setCategories(recipe.getCategories());
            return recipeRepository.save(recipeEntity);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{recipeId}")
    public void deleteRecipe(@PathVariable Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }
}
