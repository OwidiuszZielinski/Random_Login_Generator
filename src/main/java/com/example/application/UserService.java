package com.example.application;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public void addUser(UserDTO user){
        GeneratedUser newGeneratedUser = new GeneratedUser();
        newGeneratedUser.fromDTO(user);
        repository.save(newGeneratedUser);

    }

    public List<GeneratedUser> getUsers(){
        return repository.findAll();


    }
}
