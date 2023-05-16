package edu.estu.recipeapp.controller;

import edu.estu.recipeapp.entity.UserEntity;
import edu.estu.recipeapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public UserEntity updateUser(@PathVariable Long userId, UserEntity user) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();
            userEntity.setEmail(user.getEmail());
            userEntity.setPassword(user.getPassword());
            userEntity.setFullName(user.getFullName());
            userEntity.setUserType(user.getUserType());
            userEntity.setFavorites(user.getFavorites());
            return userRepository.save(userEntity);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
