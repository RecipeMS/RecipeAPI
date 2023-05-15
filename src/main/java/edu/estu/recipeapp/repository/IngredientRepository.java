package edu.estu.recipeapp.repository;

import edu.estu.recipeapp.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "ingredients")
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
}
