package com.lucenasoft.workshopmongo.controllers;

import com.lucenasoft.workshopmongo.dto.UserDTO;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserModel> users = userService.findAll();
        List<UserDTO> listDto = users.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserModel obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
