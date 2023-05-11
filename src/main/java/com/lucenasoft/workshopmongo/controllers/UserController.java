package com.lucenasoft.workshopmongo.controllers;

import com.lucenasoft.workshopmongo.models.UserModel;
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
    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> findAll() {
        UserModel gabriel = new UserModel("1","Gabriel Lucena","Gabriel@gmail.com");
        UserModel maria = new UserModel("2","Maria Lucena","Maria@gmail.com");
        List<UserModel> users = new ArrayList<>(Arrays.asList(gabriel, maria));
        return ResponseEntity.ok().body(users);
    }
}
