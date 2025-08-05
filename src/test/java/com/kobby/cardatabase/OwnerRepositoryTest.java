package com.kobby.cardatabase;

import com.kobby.cardatabase.domain.Owner;
import com.kobby.cardatabase.domain.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import(TestSecurityConfig.class)
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;


    @Test
    void saveOwner(){
        repository.save(new Owner("James", "Cameron"));

        assertThat(repository.findByFirstName("James").isPresent()).isTrue();
    }

    @Test
    void deleteOwner(){
        repository.save(new Owner("Lisa", "Morrison"));
        repository.deleteAll();

        assertThat(repository.count()).isEqualTo(0);


    }
}
