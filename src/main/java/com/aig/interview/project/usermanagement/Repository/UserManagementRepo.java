package com.aig.interview.project.usermanagement.Repository;

import org.hibernate.exception.DataException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 


import com.aig.interview.project.usermanagement.model.User;
@Repository
public interface UserManagementRepo extends JpaRepository<User,Long> {
	
	 Page<User> findAll(Pageable pageable) throws DataException ;

}
