package com.nuvizz.JobRepository.util;

import java.util.UUID;

public class UserToken {
	
	public static String createID() 
	 {
	  String uniqueKey = UUID.randomUUID().toString();
	  
	  return uniqueKey;

	 }

}
