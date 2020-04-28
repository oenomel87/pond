package dev.dane.pond.dummy;

import dev.dane.pond.user.domain.entity.User;
import dev.dane.pond.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.UUID;

@SpringBootTest
public class DummyUser {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUser() {
        var passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        var u = User.builder()
                .name("test")
                .username("testuser")
                .password(passwordEncoder.encode("test1234"))
                .usercode(UUID.randomUUID().toString().replaceAll("-", ""))
                .build();
        userRepository.save(u);
    }
}
