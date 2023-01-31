package Larome.CoffeeBook_server.repository;

import Larome.CoffeeBook_server.models.StandardRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardRecipesRepository extends JpaRepository<StandardRecipes, Integer> {
}
