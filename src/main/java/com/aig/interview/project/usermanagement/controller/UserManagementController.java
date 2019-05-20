package com.aig.interview.project.usermanagement.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aig.interview.project.usermanagement.model.User;
import com.aig.interview.project.usermanagement.service.UserManagementService;

@RestController
public class UserManagementController {

	
	@Autowired
	public UserManagementController(UserManagementService userManageService) {
		super();
		this.userManageService = userManageService;
	}

	UserManagementService userManageService;
	
	 @RequestMapping(value="/home", method = RequestMethod.GET)
	public String home() {
		 System.out.println("hi");
	return "hello"; 
	}


	
	@GetMapping(value="/users/{userId}"
	, produces = "application/json; ")
	public Optional<User> retrieveUserbyId(@PathVariable Long userId) {
		
		Optional<User> user=null;
		try {
			 user= userManageService.getUserbyId(userId);	
			if(!user.isPresent()) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "user with the above id not found "
					);
		}
		}
		catch(SQLException e) {
			
		}
		return user;
	} 

	@GetMapping(value="/users",produces = "application/json;")
	public Page<User> retrieveUsers(@RequestParam int paging,@RequestParam int limit) {
		Page<User> page = null;
		try {
		Pageable pageable = new PageRequest(paging,limit);
		   
		page= userManageService.getUsers(pageable);
		if(page.getNumberOfElements()==0) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "page not found"
					);
		}
		}catch(SQLException e) {
			
		}
		
		return page;
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		//logger.info("SQLException Occured:: URL="+request.getRequestURL());
		if(ex.getMessage().contains("page"))
		return "page not found";
		else
			return "user not found";
	}
	@PostMapping(path="/users",consumes = "application/json",produces = "application/json;")
	public ResponseEntity<User> createUser(@RequestBody User user) {
	
		
		if(user.getPassword().equalsIgnoreCase(user.getConfirm())) {
			try {
				userManageService.addUser(user);
			} catch (SQLException e) {
				
				
			}
	
			return new ResponseEntity<>( HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
	}
	
	
		
	}
	

}
