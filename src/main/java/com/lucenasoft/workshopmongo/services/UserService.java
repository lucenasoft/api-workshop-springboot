package com.lucenasoft.workshopmongo.services;

import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
}
