package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.Person;
import com.example.learnspringjpa.entities.User;
import com.example.learnspringjpa.services.GenericService;
import com.example.learnspringjpa.services.PersonService;
import com.example.learnspringjpa.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active:test")
class PersonRepositoryTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;

    @Autowired
    private GenericService<Person, Long> genericPersonService;

    @Autowired
    private GenericService<User, Long> genericUserService;

    @Test
    void personRepositoryTest() {
        var user = userService.save(User.builder().name("saino").email("saino@kk.com").build());
        var person = personService.save(Person.builder().name("saino2").email("sino@kk.com").build());
        var person2 = genericPersonService.save(Person.builder().name("saino2").email("sino@kk.com").build());
        var user2 = genericUserService.save(User.builder().name("saino2").email("sino@kk.com").build());
    }


}