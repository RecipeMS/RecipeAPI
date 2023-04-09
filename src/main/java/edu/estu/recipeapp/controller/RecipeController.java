package edu.estu.recipeapp.controller;


import edu.estu.recipeapp.entity.Recipe;
import edu.estu.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RecipeController {


    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/recipes")
    public String recipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes";
    }

    @PostMapping("/recipes")
    public String postRecipe(@ModelAttribute Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/recipes";
    }

}
