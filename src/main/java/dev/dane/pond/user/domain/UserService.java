package dev.dane.pond.user.domain;

import dev.dane.pond.user.domain.entity.User;
import dev.dane.pond.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> fetchUser(String username) {
        return this.userRepository.findByUsername(username);
    }
}
