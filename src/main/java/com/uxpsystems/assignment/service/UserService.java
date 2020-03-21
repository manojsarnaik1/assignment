package com.uxpsystems.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.exception.RecordNotFoundException;
import com.uxpsystems.assignment.model.User;

@Service
public class UserService {

	@Autowired
    UserDao repository;
     
    public List<User> getAllUsers()
    {
        List<User> userList = repository.getAllUsers();         
        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }
    }
     
    public User getUserById(Long id) throws RecordNotFoundException
    {
    	User user = repository.getUserById(id);
        if(user!=null) {
            return user;
        } else {
            throw new RecordNotFoundException("No user exist for given id");
        }
    }
     
    public User createUser(User user) throws RecordNotFoundException
    {
    		List<String> userList=getAllUsers().stream().map(User::getUsername).collect(Collectors.toList());    		
    	    if(!userList.contains(user. getUsername().trim())) { 
    		user = repository.createUser(user);             
            return user;        
    	    }else {
    	    	throw new RuntimeException("User Name already present!");
    	    }
    }
    
    public User updateUser(User user) throws RecordNotFoundException
    {
        User newEntity = repository.getUserById(user.getId());
        if(newEntity!=null)
        {	
            repository.updateUser(user);             
            return user;
        } else {
            throw new RecordNotFoundException("No user exist for given id");
        }
    }
    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        User user = repository.getUserById(id);
        if(user!=null)
        {
            repository.deleteUser(id);
        } else {
            throw new RecordNotFoundException("No user exist for given id");
        }
    }
}
