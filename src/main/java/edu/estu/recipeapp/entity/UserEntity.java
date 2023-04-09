package edu.estu.recipeapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class UserEntity {
    private String fullName;
    @Id
    private String email;
    private String password;

    @OneToMany
    private List<RecipeEntity> favorites;

    public UserEntity(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}
