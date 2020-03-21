package com.uxpsystems.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.exception.RecordNotFoundException;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;
 
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService service;
 
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)throws RecordNotFoundException {
        User entity = service.getUserById(id);
        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) throws RecordNotFoundException {
        User updated = service.createUser(user);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping(consumes = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws RecordNotFoundException {
        User updated = service.updateUser(user);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}