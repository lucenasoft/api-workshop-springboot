package com.lucenasoft.workshopmongo.config;

import com.lucenasoft.workshopmongo.models.PostModel;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.repositories.PostRepository;
import com.lucenasoft.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        UserModel u1 = new UserModel(null,"Gabriel","Gabriel@spring.com");
        UserModel u2 = new UserModel(null,"Lucas","Lucas@spring.com");
        UserModel u3 = new UserModel(null,"Deyvid","Deyvid@spring.com");

        PostModel post1 = new PostModel(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para recife!",u2);
        PostModel post2 = new PostModel(null,sdf.parse("15/05/2002"),"Uhuu nasci","Hoje eu vim ao mundo!",u1);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
