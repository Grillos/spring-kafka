package com.spring.kafka.integration.queue;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.kafka.domain.User;

@Component
public class UserProducerIntegrationQueue {
	@Value("${user.topic}")
    private String orderTopic;
 
	@Autowired
    private KafkaTemplate kafkaTemplate;
 
    public void send(final User user) {
        try {
        	final String mensageKey = UUID.randomUUID().toString();
			kafkaTemplate.send(orderTopic, mensageKey, toJson(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public String toJson(User user) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return  mapper.writeValueAsString(user);
	}


}
