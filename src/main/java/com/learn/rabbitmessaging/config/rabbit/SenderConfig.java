package com.learn.rabbitmessaging.config.rabbit;

import com.learn.rabbitmessaging.MessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
@Configuration
@Profile("sender")
public class SenderConfig {
	static {
		System.out.println("Setting up Sender configuration");
	}

	@Bean
	public MessageSender sender() {
		return new MessageSender();
	}
}
