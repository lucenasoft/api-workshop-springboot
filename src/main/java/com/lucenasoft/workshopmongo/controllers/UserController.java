package com.lucenasoft.workshopmongo.controllers;

import com.lucenasoft.workshopmongo.dto.UserDTO;
import com.lucenasoft.workshopmongo.models.PostModel;
import com.lucenasoft.workshopmongo.models.UserModel;
import com.lucenasoft.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/user/{id}/posts")
    public ResponseEntity<List<PostModel>> findPosts(@PathVariable String id) {
        UserModel obj = userService.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

    @PostMapping("/user")
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        UserModel obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri(); //Boa pratica
        return ResponseEntity.created(uri).build(); //created return 201 -< code http
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Void> update(@PathVariable String id ,@RequestBody UserDTO objDto) {
        UserModel obj = userService.fromDTO(objDto);
        obj.setId(id);
        obj = userService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
