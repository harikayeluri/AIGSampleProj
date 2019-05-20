package com.aig.interview.project.usermanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	
	
	public Optional<User> getUserbyId(Long userId)  {		
	
		return userRepo.findById(userId);
		
		
	}

	public Page<User> getUsers(Pageable pageable)  {
		
		return userRepo.findAll(pageable);
		
		
	}

	public void addUser(User user){
		try
		{userRepo.save(user);
		}
		catch(DataException e) {
			log.error("SQL Exception=", e);
		
	}
	
	
	}
	
	
	

}
