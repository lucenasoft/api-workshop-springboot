package com.lucenasoft.workshopmongo.repositories;

import com.lucenasoft.workshopmongo.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<PostModel, String> {
}
