package com.restfull.yogesh.restfull_demo.controller;

import com.restfull.yogesh.restfull_demo.dao.UserDaoService;
import com.restfull.yogesh.restfull_demo.exceptions.UserNotFoundException;
import com.restfull.yogesh.restfull_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    UserDaoService service;

    //Get /users
    // to retrieve all users
    @GetMapping("/users")
    public ArrayList<User> getAllUsers(){
        return service.findAll();
    }

    //Get /users/{id}
    // to retrieve specific users
    @GetMapping("/users/{id}")
    public User retrieveSpecificUser(@PathVariable int id){
        User user = service.findOne(id);
        if (user==null){
            throw new UserNotFoundException("id-"+ id);
        }
        return user;
    }

    //POST to save user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User createdUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Get /users/{id}
    // to delete specific users
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteUser(id);
        if (user==null){
            throw new UserNotFoundException("id-"+ id);
        }
    }

}
