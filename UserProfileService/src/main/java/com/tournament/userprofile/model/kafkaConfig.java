package com.tournament.userprofile.model;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class kafkaConfig {
	
	@Bean
	public NewTopic topic() {
		return new NewTopic("UserAuth",32,(short)1);
	}
	
	@Bean
	public DefaultErrorHandler eh(KafkaTemplate<String, String> template) {
		return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(template), new FixedBackOff(0L, 2L));
	}
//	@Bean
//    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
//            ConsumerFactory<Object, Object> kafkaConsumerFactory) {
//
//        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        configurer.configure(factory, kafkaConsumerFactory);
//        factory.setErrorHandler(new );
//        return factory;
//    }
}
