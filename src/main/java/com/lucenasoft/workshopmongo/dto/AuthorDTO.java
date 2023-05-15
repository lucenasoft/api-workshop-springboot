package com.lucenasoft.workshopmongo.dto;

import com.lucenasoft.workshopmongo.models.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO(UserModel obj){
        this.id = obj.getId();
        this.name = obj.getName();
    }
}
