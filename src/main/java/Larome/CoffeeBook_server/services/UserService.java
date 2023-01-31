package Larome.CoffeeBook_server.services;

import Larome.CoffeeBook_server.models.User;
import Larome.CoffeeBook_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User updated_user, int id) {
        updated_user.setId(id);
        userRepository.save(updated_user);
    }

    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
