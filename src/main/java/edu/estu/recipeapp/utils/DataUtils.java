package edu.estu.recipeapp.utils;

import edu.estu.recipeapp.entity.*;
import edu.estu.recipeapp.repository.IngredientRepository;
import edu.estu.recipeapp.repository.RecipeRepository;
import edu.estu.recipeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataUtils {

    private static UserRepository userRepository;

    private static RecipeRepository recipeRepository;

    private static IngredientRepository ingredientRepository;

    @Autowired
    public DataUtils(UserRepository userRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        DataUtils.userRepository = userRepository;
        DataUtils.recipeRepository = recipeRepository;
        DataUtils.ingredientRepository = ingredientRepository;
    }

    public static void initializeRecords() {
        // Create an admin user
        UserEntity admin = new UserEntity("Admin", "admin@recipe.com", "admin", "admin");

        // Save the admin user to the database
        userRepository.save(admin);

        // Create three users
        UserEntity user1 = new UserEntity("User 1", "user1@recipe.com", "user1", "user");
        UserEntity user2 = new UserEntity("User 2", "user2@recipe.com", "user2", "user");
        UserEntity user3 = new UserEntity("User 3", "user3@recipe.com", "user3", "user");

        // Save the users to the database
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Create kebab recipe
        RecipeEntity kebab = new RecipeEntity("Kebab", "Kebab is a dish of meat cooked on a skewer, usually a vertical spit roasted over a fire. It is a popular dish in many countries, and is often served with rice or flatbread.", 1);
        kebab.addCategory(Category.LUNCH);
        kebab.addCategory(Category.DINNER);
        kebab.addTag(Tag.HOT);
        kebab.addTag(Tag.SPICY);
        kebab.addTag(Tag.HALAL);
        kebab.addIngredient(new IngredientEntity("Meat", 0.3, Unit.KILOGRAM));
        kebab.addIngredient(new IngredientEntity("Onion", 0.5, Unit.PIECE));
        kebab.addIngredient(new IngredientEntity("Tomato", 1, Unit.PIECE));
        kebab.addIngredient(new IngredientEntity("Lettuce", 1, Unit.PIECE));
        kebab.addIngredient(new IngredientEntity("Bread", 0.5, Unit.HALF));
        kebab.addIngredient(new IngredientEntity("Sauce", 0.1, Unit.LITER));

        // Create ice cream recipe
        RecipeEntity iceCream = new RecipeEntity("Ice Cream", "Ice cream is a sweetened frozen food typically eaten as a snack or dessert. It is usually made from dairy products, such as milk and cream, and often combined with fruits or other ingredients and flavours.", 1);
        iceCream.addCategory(Category.DESSERT);
        iceCream.addTag(Tag.COLD);
        iceCream.addIngredient(new IngredientEntity("Milk", 0.5, Unit.LITER));
        iceCream.addIngredient(new IngredientEntity("Cream", 0.5, Unit.LITER));
        iceCream.addIngredient(new IngredientEntity("Sugar", 0.1, Unit.KILOGRAM));
        iceCream.addIngredient(new IngredientEntity("Vanilla", 4, Unit.TEASPOON));

        // Create pizza recipe
        RecipeEntity pizza = new RecipeEntity("Pizza", "Pizza is a savory dish of Italian origin consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients baked at a high temperature, traditionally in a wood-fired oven.", 1);
        pizza.addCategory(Category.LUNCH);
        pizza.addCategory(Category.DINNER);
        pizza.addTag(Tag.HOT);
        pizza.addTag(Tag.SPICY);
        pizza.addIngredient(new IngredientEntity("Flour", 0.5, Unit.KILOGRAM));
        pizza.addIngredient(new IngredientEntity("Water", 0.5, Unit.LITER));
        pizza.addIngredient(new IngredientEntity("Salt", 0.1, Unit.TEASPOON));
        pizza.addIngredient(new IngredientEntity("Tomato", 0.5, Unit.LITER));
        pizza.addIngredient(new IngredientEntity("Cheese", 0.5, Unit.KILOGRAM));
        pizza.addIngredient(new IngredientEntity("Pepperoni", 0.5, Unit.KILOGRAM));

        // save ingredients to the database
        ingredientRepository.saveAll(kebab.getIngredients());
        ingredientRepository.saveAll(iceCream.getIngredients());
        ingredientRepository.saveAll(pizza.getIngredients());

        // Save the recipes to the database
        recipeRepository.save(kebab);
        recipeRepository.save(iceCream);
        recipeRepository.save(pizza);
    }
}
