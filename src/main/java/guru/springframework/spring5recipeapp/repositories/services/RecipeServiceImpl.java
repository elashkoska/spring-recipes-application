package guru.springframework.spring5recipeapp.repositories.services;

import guru.springframework.spring5recipeapp.domain.Recipe;
import guru.springframework.spring5recipeapp.exceptions.NotFoundException;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository=recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe>recipeSet=new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long aLong) {
        Optional<Recipe>recipeOptional=recipeRepository.findById(aLong);

        if(!recipeOptional.isPresent()){
            //throw new RuntimeException();
            throw new NotFoundException("Recipe not found");
        }
        return recipeOptional.get();
    }
}
