package com.lucenasoft.workshopmongo.dto;

import com.lucenasoft.workshopmongo.models.UserModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(UserModel user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
