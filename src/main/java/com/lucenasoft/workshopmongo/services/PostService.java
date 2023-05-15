package com.lucenasoft.workshopmongo.services;

import com.lucenasoft.workshopmongo.models.PostModel;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.repositories.PostRepository;
import com.lucenasoft.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostModel findById(String id) {
        Optional<PostModel> user = postRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Post not found: " + id));
    }

    public List<PostModel> findbyTitle(String text){
        return postRepository.searchTitle(text);
    }
}
