package com.lucenasoft.workshopmongo.repositories;

import com.lucenasoft.workshopmongo.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<PostModel, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<PostModel> searchTitle(String text); // metodo do mongodb
    List<PostModel> findByTitleContainingIgnoreCase(String text);
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<PostModel> fullSearch(String text, Date minDate, Date maxDate);
}
