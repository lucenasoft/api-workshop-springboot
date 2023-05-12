package com.lucenasoft.workshopmongo.config;

import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        UserModel u1 = new UserModel(null,"Gabriel","Gabriel@spring.com");
        UserModel u2 = new UserModel(null,"Lucas","Lucas@spring.com");
        UserModel u3 = new UserModel(null,"Deyvid","Deyvid@spring.com");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
    }
}
