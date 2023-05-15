package com.lucenasoft.workshopmongo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document(collection = "user") // Usado para mapear a collection no mongoDB
public class UserModel implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    @DBRef(lazy = true) // garante que os post serão carregados se eu explicitamentes acessa-los
    private List<PostModel> posts = new ArrayList<>();

    public UserModel(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
