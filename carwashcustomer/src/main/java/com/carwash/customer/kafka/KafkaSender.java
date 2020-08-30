package com.carwash.customer.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import com.carwash.customer.model.CarDetails;

@Service
public class KafkaSender {
	 
	public static String getBootstrapServers() {
			return BOOTSTRAP_SERVERS;
	}
	 
	private final static String BOOTSTRAP_SERVERS =
				"localhost:9092,localhost:9093,localhost:9094";
	
	@Bean
    public KafkaTemplate<String, CarDetails> kafkaTemplate() {
    		return new KafkaTemplate<>(producerFactory());
    }
	
	@Bean
	public ProducerFactory<String, CarDetails> producerFactory() {
		Map<String, Object> config = new HashMap<>();
        
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        
        return new DefaultKafkaProducerFactory<>(config);
        		

    }
}