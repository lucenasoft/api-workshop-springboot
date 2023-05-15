package com.lucenasoft.workshopmongo.repositories;

import com.lucenasoft.workshopmongo.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<PostModel, String> {
    List<PostModel> findByTitleContainingIgnoreCase(String text);
}
