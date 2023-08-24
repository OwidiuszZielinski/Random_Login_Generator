package com.example.application;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class UserDTO {

    private long id;
    private String name;
    private String surname;
    private String username;

    public UserDTO(String name, String surname, String username) {

        this.name = name;
        this.surname = surname;
        this.username = username;
    }


}
