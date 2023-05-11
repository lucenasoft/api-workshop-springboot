package com.lucenasoft.workshopmongo.models;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class UserModel implements Serializable {

    private String id;
    private String name;
    private String email;

}
