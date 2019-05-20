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

import com.aig.interview.project.usermanagement.model.PostResponse;
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
	return "hello"; 
	}


	
	@GetMapping(value="api/v1/users/{userId}"	, produces = "application/json; ")
	public Optional<User> retrieveUserbyId(@PathVariable Long userId) {
<<<<<<< HEAD
		Optional<User> user=null;
=======
		
		Optional<User> user=null;
		//Adding try
		try {
			
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
			 user= userManageService.getUserbyId(userId);	
			if(!user.isPresent()) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "user with the above id not found "
					);
<<<<<<< HEAD
			}
		
		
=======
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
		return user;
	} 

<<<<<<< HEAD
	@GetMapping(value="api/v1/users",produces = "application/json;")
	public PostResponse retrieveUsers(@RequestParam(value="paging",required=false) String paging,
			@RequestParam(value="limit", required=false)String limit) {
		Page<User> pageList = null;
		PostResponse pr=null;
		Pageable pageable=null;				
		if((paging != null && !paging.isEmpty())&&( limit!=null&&!limit.isEmpty())) { 
			 pageable = PageRequest.of(Integer.parseInt(paging) , Integer.parseInt(limit));
			pageList= userManageService.getUsers(pageable);
=======
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
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
		}
<<<<<<< HEAD
		else {	
			
			pageable = PageRequest.of(0, 10);
			pageList= userManageService.getUsers(pageable);
		}		
		if(pageList.getNumberOfElements()>0) {
			pr=new PostResponse();
		pr.setCount(pageList.getNumberOfElements());
		pr.setPaging(pageable.getPageNumber());
		pr.setUserList(pageList.getContent());
		}
		if(pageList.getNumberOfElements()==0) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "page  not found "
					);
			}
=======
		}catch(SQLException e) {
			e.printStackTrace();
		}
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
		
		return pr;
	}
	 
	
	@PostMapping(path="/api/v1/users",consumes = "application/json",produces = "application/json;")
	public ResponseEntity<User> createUser(@RequestBody User user) {		
		if(user.getPassword().equalsIgnoreCase(user.getConfirm())) {	
			userManageService.addUser(user);	
	
			return new ResponseEntity<>( HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
		}
	@ExceptionHandler(ResponseStatusException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		//logger.info("SQLException Occured:: URL="+request.getRequestURL());
		if(ex.getMessage().contains("page"))
		return "page not found";
		else
			return "user not found";
	}
<<<<<<< HEAD
=======
	@PostMapping(path="/users",consumes = "application/json",produces = "application/json;")
	public ResponseEntity<User> createUser(@RequestBody User user) {
	
		
		if(user.getPassword().equalsIgnoreCase(user.getConfirm())) {
			try {
				userManageService.addUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
	
			return new ResponseEntity<>( HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
	}
	
	
		
	}
	
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj

}
