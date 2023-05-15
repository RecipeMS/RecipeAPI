package edu.estu.recipeapp.controller;

import edu.estu.recipeapp.entity.Category;
import edu.estu.recipeapp.entity.RecipeEntity;
import edu.estu.recipeapp.entity.Tag;
import edu.estu.recipeapp.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@RestController()
@RequestMapping("/recipes")
public class RecipeController {
    RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    //get filtered recipes by tags and categories as query params, if query params contains any tag that recipe has, it will be returned
    @GetMapping
    public Iterable<RecipeEntity> getFilteredRecipes(@RequestParam(required = false) Tag tag, @RequestParam(required = false) Category category) {
        Iterable<RecipeEntity> recipes = recipeRepository.findAll();
        System.out.println("-------------------------------------------------------------");
        System.out.println(tag);

        if (tag != null) {
            ArrayList<RecipeEntity> filteredRecipes = new ArrayList<>();
            recipes.forEach(recipe -> {
                Set<Tag> tags = recipe.getTags();
                if (tags.contains(tag)) {
                    filteredRecipes.add(recipe);
                }
            });
            return filteredRecipes;

        } else if (category != null) {
            ArrayList<RecipeEntity> filteredRecipes = new ArrayList<>();
            recipes.forEach(recipe -> {
                Set<Category> categories = recipe.getCategories();
                if (categories.contains(category)) {
                    filteredRecipes.add(recipe);
                }
            });
            return filteredRecipes;
        }

        return recipes;

    }

    @PostMapping
    public RecipeEntity createRecipe(RecipeEntity recipe) {
        return recipeRepository.save(recipe);
    }

    @GetMapping("/{recipeId}")
    public RecipeEntity getRecipe(@PathVariable Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @PutMapping("/{recipeId}")
    public RecipeEntity updateRecipe(@PathVariable Long recipeId, RecipeEntity recipe) {
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
