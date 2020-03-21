package com.uxpsystems.assignment.model;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_user")
public class User {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name="username" ,unique = true)
	    private String username ;
	    
	    @Column(name="password" )
	    private String password ;
	    
	    @Column(name="status")
	    private String status;
	    
	    public User() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
	         byte[] decodePwd = Base64.getDecoder().decode(password);
			try {
				return  new String(decodePwd, "utf-8") ;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return null;
		}

		public void setPassword(String password) {
			try {
				String encodePwd = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
				this.password = encodePwd;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
}
