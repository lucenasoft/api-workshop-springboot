package com.lucenasoft.workshopmongo.controllers;

import com.lucenasoft.workshopmongo.dto.UserDTO;
import com.lucenasoft.workshopmongo.models.PostModel;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public ResponseEntity<PostModel> findById(@PathVariable String id) {
        PostModel obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
