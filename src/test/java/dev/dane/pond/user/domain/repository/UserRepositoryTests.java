package dev.dane.pond.user.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void finaAllUserTest() {
        assertThat(this.repository.findAll()).isNotNull();
    }
}
