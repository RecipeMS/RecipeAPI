package edu.estu.recipeapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @Column(updatable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userType;

    @ManyToMany
    private List<RecipeEntity> favorites = new ArrayList<>();

    public UserEntity(String fullName, String email, String password, String userType) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public void addFavorite(RecipeEntity recipe) {
        this.favorites.add(recipe);
    }
}
