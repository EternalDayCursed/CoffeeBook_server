package Larome.CoffeeBook_server.controllers;

import Larome.CoffeeBook_server.DTO.StandardRecipesDTO;
import Larome.CoffeeBook_server.DTO.UserRecipesDTO;
import Larome.CoffeeBook_server.models.StandardRecipes;
import Larome.CoffeeBook_server.models.User;
import Larome.CoffeeBook_server.models.UserRecipes;
import Larome.CoffeeBook_server.services.StandardRecipesService;
import Larome.CoffeeBook_server.services.UserRecipesService;
import Larome.CoffeeBook_server.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellUserTestController {

    private final UserService userService;
    private final StandardRecipesService standardRecipesService;
    private final UserRecipesService userRecipesService;

    private final ModelMapper modelMapper;

    @ShellMethod(key = "CreateU", value = "creating new user")
    public void createUserTest() {
        User user = new User();
        user.setName("Andrew");
        user.setSurname("Parlo");
        user.setEmail("7236857234@gmail.com");
        user.setNickname("AAA");
        userService.createUser(user);
    }

    @ShellMethod(key = "GASR", value = "Get All Standard Coffee Recipes")
    public List<StandardRecipes> getAllStandardRecipesTest() {
        return standardRecipesService.getAllStandardRecipes();
    }

    @ShellMethod(key = "CUR", value = "Create new User Recipe")
    public void createUR(int id) {
        UserRecipes userRecipes = new UserRecipes();
        userRecipes.setUR_name("1x LATTE");
        userRecipes.setUR_desc("30ml Espresso, 180ml Milk");
        userRecipes.setUR_preparation("COOOK3");
        userRecipes.setUserOwner(userService.findUserById(id));

        userRecipesService.createRecipes(userRecipes);
    }

    @ShellMethod(key = "GAUR", value = "Get All Users Recipe")
    public void getAllUR() {
        List<UserRecipesDTO> u = userRecipesService.userRecipesList().stream()
                .map(this::convertToUserRecipesDTO).toList();
        for (UserRecipesDTO d : u) {
            System.out.println(d);
        }
    }

    @ShellMethod(key = "GURBUI", value = "Get User Recipes By User")
    public void getUserRecipes() {
        List<UserRecipesDTO> u = userRecipesService.getAllUserRecipeByUserId(userService.findUserById(3)).stream()
                .map(this::convertToUserRecipesDTO).toList();

        for (UserRecipesDTO d : u) {
            System.out.println(d);
        }
    }

    private StandardRecipesDTO convertToStandardRecipesDTO(StandardRecipes standardRecipes) {
        return modelMapper.map(standardRecipes, StandardRecipesDTO.class);
    }

    private UserRecipesDTO convertToUserRecipesDTO(UserRecipes userRecipes) {
        return modelMapper.map(userRecipes, UserRecipesDTO.class);
    }
}
