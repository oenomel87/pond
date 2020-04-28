package dev.dane.pond.event.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class EventRepositoryTests {

    @Autowired
    private EventRepository repository;

    @Test
    public void findAllTest() {
        assertThat(this.repository.findAll());
    }
}
