package com.uxpsystems.assignment.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.exception.RecordNotFoundException;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;



public class UserControllerTest {
	 	
		@InjectMocks
	    UserService userService;
	     
	    @Mock
	    UserDao userDao;
	    
	    @Before
	    public void setUp() throws Exception {
	         MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void getAllUserTest()
	    {
	        List<User> list = new ArrayList<User>();
	    	  User userD = new User(); 
	    	  userD.setId(1l); 
	    	  userD.setUsername("manojsarnaik");
			  userD.setStatus("Activated"); 
			  userD.setPassword("manoj@123");
			 
	        list.add(userD);
	         
	        when(userDao.getAllUsers()).thenReturn(list);
	         
	        List<User> userList = userService.getAllUsers();
	         
	        assertEquals(1, userList.size());
	        verify(userDao, times(1)).getAllUsers();
	    }
	     
	    @Test
	    public void getUserByIdTest() throws RecordNotFoundException
	    {
	    	  User userD = new User(); 
	    	  userD.setId(1l); 
	    	  userD.setUsername("manojsarnaik");
			  userD.setStatus("Activated"); 
			  userD.setPassword("manoj@123");
			
			  when(userDao.getUserById(1l)).thenReturn(userD);
	         
	        User user = userService.getUserById(1l);
	         
	        assertEquals("manojsarnaik", user.getUsername());
	        assertEquals("Activated", user.getStatus());
	    }
	     
	    @Test
	    public void createUserTest() throws RecordNotFoundException
	    {
	    	  User userD = new User(); 
	    	  userD.setId(1l); 
	    	  userD.setUsername("manojsarnaik");
			  userD.setStatus("Activated"); 
			  userD.setPassword("manoj@123");
			  
	        userService.createUser(userD);
	         
	        verify(userDao, times(1)).createUser(userD);
	    }
	
	    @Test
	    public void deleteUserTest() throws RecordNotFoundException
	    {
	    	 User userD = new User(); 
	    	  userD.setId(1l); 
	    	  userD.setUsername("manojsarnaik");
			  userD.setStatus("Activated"); 
			  userD.setPassword("manoj@123");
			
			 when(userDao.getUserById(1l)).thenReturn(userD);
	        userService.deleteUserById(1l);	         
	        verify(userDao, times(1)).deleteUser(1l);
	    }
  
}