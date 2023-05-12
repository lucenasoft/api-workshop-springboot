package com.lucenasoft.workshopmongo.services;

import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.repositories.UserRepository;
import com.lucenasoft.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(String id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found: " + id));
    }
}
