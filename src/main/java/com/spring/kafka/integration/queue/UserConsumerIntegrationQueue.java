package com.spring.kafka.integration.queue;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.spring.kafka.domain.User;

@Component
public class UserConsumerIntegrationQueue {

	@KafkaListener(topics = "${user.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String user) {

		System.out.println(":: USER :: "+user);
    }
}
