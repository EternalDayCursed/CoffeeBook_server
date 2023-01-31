package Larome.CoffeeBook_server.services;

import Larome.CoffeeBook_server.models.StandardRecipes;
import Larome.CoffeeBook_server.repository.StandardRecipesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StandardRecipesService {

    private final StandardRecipesRepository recipesRepository;

    public List<StandardRecipes> getAllStandardRecipes() {
        return recipesRepository.findAll();
    }
}
