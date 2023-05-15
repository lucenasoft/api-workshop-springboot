package com.lucenasoft.workshopmongo.controllers;

import com.lucenasoft.workshopmongo.controllers.util.URL;
import com.lucenasoft.workshopmongo.dto.UserDTO;
import com.lucenasoft.workshopmongo.models.PostModel;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/posts/titlesearch")
    public ResponseEntity<List<PostModel>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<PostModel> list = postService.findbyTitle(text);
        return ResponseEntity.ok().body(list );
    }
}
