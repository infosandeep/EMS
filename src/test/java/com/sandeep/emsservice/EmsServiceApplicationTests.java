package com.sandeep.emsservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.sandeep.emsservice.repository.EmsRepository;

@SpringBootTest
class EmsServiceApplicationTests {
	
	@Autowired
	EmsRepository repo; 

	@Test
	void contextLoads() {
		
		assertNotNull(repo.getById(34));
		
	}
	
	
	
	
	

}
