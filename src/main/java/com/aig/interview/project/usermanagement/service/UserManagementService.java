package com.aig.interview.project.usermanagement.service;

<<<<<<< HEAD
=======
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
import java.util.Optional;

import org.hibernate.exception.DataException; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aig.interview.project.usermanagement.Repository.UserManagementRepo;
import com.aig.interview.project.usermanagement.model.User;


@Service
public class UserManagementService {
	
	private static final Logger log = LoggerFactory.getLogger(UserManagementService.class);
	@Autowired
	UserManagementRepo userRepo;
	
<<<<<<< HEAD
	
	public Optional<User> getUserbyId(Long userId)  {		
	
		return userRepo.findById(userId);
=======

	/*private List<User> users= new ArrayList(
			Arrays.asList(new User((long) 1001,"Harika","password1"),
					new User((long) 1002,"Rita","password2")))
		;*/

	public Optional<User> getUserbyId(Long userId) throws SQLException {
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
		
		
<<<<<<< HEAD
=======
		// return users.stream().filter(s->s.getUUID().equals(userId)).findFirst().get();
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
	}

<<<<<<< HEAD
	public Page<User> getUsers(Pageable pageable)  {
=======
	public Page<User> getUsers(Pageable pageable) throws SQLException {
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
		
		return userRepo.findAll(pageable);
		
<<<<<<< HEAD
		
=======
		// return users;
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
	}

<<<<<<< HEAD
	public void addUser(User user){
		try
		{userRepo.save(user);
		}
		catch(DataException e) {
			log.error("SQL Exception=", e);
		
=======
	public void addUser(User user)throws SQLException {
		 userRepo.save(user);
		// users.add(user) ;
>>>>>>> branch 'may20' of https://github.com/harikayeluri/AIGSampleProj
	}
	
	
	}
	
	
	

}
