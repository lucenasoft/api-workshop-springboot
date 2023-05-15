package com.lucenasoft.workshopmongo.config;

import com.lucenasoft.workshopmongo.dto.AuthorDTO;
import com.lucenasoft.workshopmongo.dto.CommentDTO;
import com.lucenasoft.workshopmongo.models.PostModel;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.repositories.PostRepository;
import com.lucenasoft.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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

        userRepository.saveAll(Arrays.asList(u1,u2,u3)); // salva primeiro os user para gerar o id e não ir null no post

        PostModel post1 = new PostModel(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para recife!",new AuthorDTO(u2));
        PostModel post2 = new PostModel(null,sdf.parse("15/05/2002"),"Uhuu nasci","Hoje eu vim ao mundo!",new AuthorDTO(u1));

        CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("uhuuu!!", sdf.parse("15/05/2002"), new AuthorDTO(u1));

        post1.getComments().add(c1);
        post2.getComments().add(c2);

        postRepository.saveAll(Arrays.asList(post1,post2));

        u1.getPosts().add(post1);
        u2.getPosts().add(post2);
        userRepository.save(u1);
        userRepository.save(u2);
    }
}
