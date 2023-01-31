package Larome.CoffeeBook_server.repository;

import Larome.CoffeeBook_server.models.User;
import Larome.CoffeeBook_server.models.UserRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRecipesRepository extends JpaRepository<UserRecipes, Integer> {

    List<UserRecipes> findUserRecipesByUserOwner(User user);

}
