package com.lucenasoft.workshopmongo.repositories;

import com.lucenasoft.workshopmongo.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {
}
