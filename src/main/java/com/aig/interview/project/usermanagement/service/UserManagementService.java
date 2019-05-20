package com.aig.interview.project.usermanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aig.interview.project.usermanagement.Repository.UserManagementRepo;
import com.aig.interview.project.usermanagement.model.User;


@Service
public class UserManagementService {
	
	@Autowired
	UserManagementRepo userRepo;
	

	/*private List<User> users= new ArrayList(
			Arrays.asList(new User((long) 1001,"Harika","password1"),
					new User((long) 1002,"Rita","password2")))
		;*/

	public Optional<User> getUserbyId(Long userId) throws SQLException {
		
	return userRepo.findById(userId);
		
		// return users.stream().filter(s->s.getUUID().equals(userId)).findFirst().get();
	}

	public Page<User> getUsers(Pageable pageable) throws SQLException {
		
		return userRepo.findAll(pageable);
		
		//return users;
	}

	public void addUser(User user)throws SQLException {
		 userRepo.save(user);
		// users.add(user) ;
	}
	
	
	
	
	
	

}
