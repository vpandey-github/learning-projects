package com.nuvizz.JobRepository.dao;

import com.nuvizz.JobRepository.dto.UserDTO;

public interface LoginDAOI  {
	
	
	public UserDTO authenticate(UserDTO dto);
	//public UserDTO authenticateRestUserDAO(LoginAction dto);
	

}
