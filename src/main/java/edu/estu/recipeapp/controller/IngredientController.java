package edu.estu.recipeapp.controller;

import edu.estu.recipeapp.entity.IngredientEntity;
import edu.estu.recipeapp.repository.IngredientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/ingredients")
public class IngredientController {
    IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping
    public Iterable<IngredientEntity> getIngredients() {
        return ingredientRepository.findAll();
    }


    @PostMapping
    public IngredientEntity createIngredient(@RequestBody IngredientEntity ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @GetMapping("/{ingredientId}")
    public IngredientEntity getIngredient(@PathVariable Long ingredientId) {
        return ingredientRepository.findById(ingredientId).orElse(null);
    }

    @PutMapping("/{ingredientId}")
    public IngredientEntity updateIngredient(@PathVariable Long ingredientId,@RequestBody IngredientEntity ingredient) {
        Optional<IngredientEntity> ingredientOptional = ingredientRepository.findById(ingredientId);
        if (ingredientOptional.isPresent()) {
            IngredientEntity ingredientEntity = ingredientOptional.get();
            ingredientEntity.setName(ingredient.getName());
            ingredientEntity.setAmount(ingredient.getAmount());
            ingredientEntity.setUnit(ingredient.getUnit());

            return ingredientRepository.save(ingredientEntity);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{ingredientId}")
    public void deleteIngredient(@PathVariable Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
}
