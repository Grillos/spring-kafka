package com.spring.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kafka.domain.User;
import com.spring.kafka.integration.queue.UserProducerIntegrationQueue;

@Service
public class UserService {
	
	@Autowired
	private UserProducerIntegrationQueue userProducerIntegrationQueue;
	
	public void send(User user) {
		
		userProducerIntegrationQueue.send(user);
	}

}
