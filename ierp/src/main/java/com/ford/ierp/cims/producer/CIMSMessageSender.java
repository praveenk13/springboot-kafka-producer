package com.ford.ierp.cims.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ford.ierp.cims.model.IERPMessage;

@Component
@EnableScheduling
public class CIMSMessageSender {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	private final String payload = "{\"userId\":\"Janne\",\"duration\":5,\"data\":138}";

	@Scheduled(fixedDelay = 1000)
	public void sendEvents() {

		String uniqueId = java.util.UUID.randomUUID().toString();
		IERPMessage ierpMessage = IERPMessage.builder().eventType("Initiated").payload(payload).systemName("CMM")
				.interfaceName("PR").uniqueId(uniqueId).build();
		kafkaTemplate.send("CIMS", uniqueId, ierpMessage);
		System.out.println("Send Message"+uniqueId);
	
	}
}
