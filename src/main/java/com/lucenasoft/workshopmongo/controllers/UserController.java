package com.lucenasoft.workshopmongo.controllers;

import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }
}
