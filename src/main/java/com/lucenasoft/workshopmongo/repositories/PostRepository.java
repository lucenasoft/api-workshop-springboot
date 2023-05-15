package com.lucenasoft.workshopmongo.repositories;

import com.lucenasoft.workshopmongo.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<PostModel, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<PostModel> searchTitle(String text); // metodo do mongodb
    List<PostModel> findByTitleContainingIgnoreCase(String text);
}
