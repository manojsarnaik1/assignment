# Run The project should be easily locally executable without 
# any extra conﬁguration with the following commands:

 D:\assignment_maven> mvn clean install 
 D:\assignment_maven> mvn spring-boot:run

# Rest API developed in with bellow configuration with feature
1] create springboot REST API with annotation base 
2] h2 memory database present in springboot there are two sql file present in src/main/resources folder
	i) data.sql (for create table)
	ii)schema.sql  (insert data)  
3]spring basic security use bellow credential
       username = admin
       password = admin
4]also write test cases
5]use password Base 64 Encoder / Decode        


# find the bellow urls with authenticated 
Note : -use above credential or genrated token
        token pass field in heade 
        e.g Authorization = abcdxzolll

1]Create New User use HTTP METHOD [POST]  also maintain username unique  
   url  : - http://localhost:9090/user
   body : - consume : application/json
   		    {
			"username": "manojsarnaik",
    		"password": "manoj@123",
    		"status": "Activated"
			}	
   O/p  : - status code is 200 (OK)
   			{
	        "id": 1,
	        "username": "manojsarnaik",
	        "password": "manoj@123",
	        "status": "Activated"
    		}
    		
2]Get all user use HTTP METHOD [GET] 
    url : http://localhost:9090/user
	O/P : - status code is 200 (OK) 
	     [
     	    {
     	        "id": 1,
     	        "username": "manojsarnaik",
     	        "password": "manoj@123",
     	        "status": "Activated"
     	    },
     	    {
     	        "id": 2,
     	        "username": "akshay",
     	        "password": "akshay@123",
     	        "status": "Deactivated"
     	    }
          ]	
          
3]update user use HTTP METHOD (PUT)       
	 url  : - http://localhost:9090/user
   body : - consume : application/json
   		    {
   		     "id": 3,
			"username": "manojsarnaik",
    		"password": "manoj@123",
    		"status": "Deactivated"
			}	
   O/p  : - status code is 200 (OK)
   			{
	        "id": 3,
	        "username": "manojsarnaik",
	        "password": "manoj@123",
	        "status": "Dactivated"
    		}   	

4] delete user use HTTP METHOD (DELETE)
    		url  : - http://localhost:9090/user/2
    		  O/p  : - status code is 200 (OK)
    		  
4] get perticular user use HTTP METHOD (GET)  
    		url  : - http://localhost:9090/user/1
    		  O/p  : - status code is 200 (OK) 
	    		  {
            		    "id": 1,
            		    "username": "manojsarnaik",
            		    "password": "manoj@123",
            		    "status": "Activated"
				  }   		  
 