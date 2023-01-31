package Larome.CoffeeBook_server.services;

import Larome.CoffeeBook_server.models.User;
import Larome.CoffeeBook_server.models.UserRecipes;
import Larome.CoffeeBook_server.repository.UserRecipesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserRecipesService {

    private final UserRecipesRepository userRecipesRepository;

    public List<UserRecipes> userRecipesList() {
        return userRecipesRepository.findAll();
    }

    public List<UserRecipes> getAllUserRecipeByUserId(User user) {
        return userRecipesRepository.findUserRecipesByUserOwner(user);
    }

    @Transactional
    public void createRecipes(UserRecipes userRecipes) {
        userRecipesRepository.save(userRecipes);
    }

    @Transactional
    public void updateRecipes(UserRecipes updatedUserRecipes, int id) {
        updatedUserRecipes.setUR_id(id);
        userRecipesRepository.save(updatedUserRecipes);
    }

    @Transactional
    public void deleteRecipes(int id) {
        userRecipesRepository.deleteById(id);
    }


}
