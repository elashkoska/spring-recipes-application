package guru.springframework.spring5recipeapp.repositories.services;

import guru.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe>getRecipes();
    Recipe findById(Long aLong);
}
