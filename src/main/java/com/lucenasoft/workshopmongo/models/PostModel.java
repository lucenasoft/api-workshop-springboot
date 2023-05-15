package com.lucenasoft.workshopmongo.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document(collection = "post") // Usado para mapear a collection no mongoDB
public class PostModel implements Serializable {

    private String id;
    private Date date;
    private String title;
    private String body;
    private UserModel author;

}
