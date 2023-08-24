package com.example.application;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class GeneratedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long Id;
    private String name;
    private String surname;
    private String username;




    public void  fromDTO(UserDTO userDTO) {
    this.Id = userDTO.getId();
    this.name = userDTO.getName();
    this.surname = userDTO.getSurname();
    this.username = userDTO.getUsername();

    }
}
