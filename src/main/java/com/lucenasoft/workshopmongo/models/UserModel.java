package com.lucenasoft.workshopmongo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document(collection = "user")
public class UserModel implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

}
