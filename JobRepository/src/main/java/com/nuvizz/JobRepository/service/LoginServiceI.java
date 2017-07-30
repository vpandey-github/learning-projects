package com.nuvizz.JobRepository.service;

import com.nuvizz.JobRepository.dto.UserDTO;

public interface LoginServiceI {
	public UserDTO authenticateUserService(UserDTO dto);
	//public UserDTO authenticateRestUserService(LoginAction dto);

}
