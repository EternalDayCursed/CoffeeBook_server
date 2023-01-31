package Larome.CoffeeBook_server.controllers;

import Larome.CoffeeBook_server.DTO.StandardRecipesDTO;
import Larome.CoffeeBook_server.DTO.UserRecipesDTO;
import Larome.CoffeeBook_server.exceptions.UserNotCreatedException;
import Larome.CoffeeBook_server.models.StandardRecipes;
import Larome.CoffeeBook_server.models.User;
import Larome.CoffeeBook_server.models.UserRecipes;
import Larome.CoffeeBook_server.services.StandardRecipesService;
import Larome.CoffeeBook_server.services.UserRecipesService;
import Larome.CoffeeBook_server.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final StandardRecipesService standardRecipesService;
    private final UserRecipesService userRecipesService;

    private final ModelMapper modelMapper;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMsg.append(error.getField()).append("-").append(error.getDefaultMessage()).append(";");
            }

            throw new UserNotCreatedException(errorMsg.toString());
        }

        userService.createUser(user);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }


}
