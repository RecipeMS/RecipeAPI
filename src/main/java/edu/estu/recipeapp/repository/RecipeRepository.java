package edu.estu.recipeapp.repository;

import edu.estu.recipeapp.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "recipes")
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
}

