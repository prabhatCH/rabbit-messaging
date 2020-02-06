package com.learn.rabbitmessaging.config.rabbit;

import com.learn.rabbitmessaging.MessageReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
@Configuration
@Profile("receiver")
public class ReceiverConfig {

	static {
		System.out.println("Setting up Receiver configuration");
	}

	@Bean
	public MessageReceiver receiver() {
		return new MessageReceiver();
	}

	private static class QueueConfig {
		@Bean
		public Queue planetVenusQueue() {
			return new Queue("venus", false);
		}

		@Bean
		public Queue planetEarthQueue() {
			return new Queue("earth", false);
		}

		@Bean
		public Queue planetMarsQueue() {
			return new Queue("mars", false);
		}

		@Bean
		public Queue planetTopicQueue() {
			return new Queue("planets", false);
		}
	}

	private static class QueueBindingConfig {
		//Topic bindings
		@Bean
		public Binding venusPlanetBinding(Queue planetVenusQueue, TopicExchange topicExchange) {
			return BindingBuilder.bind(planetVenusQueue).to(topicExchange).with("planet.venus");
		}

		@Bean
		public Binding earthPlanetBinding(Queue planetEarthQueue, TopicExchange topicExchange) {
			return BindingBuilder.bind(planetEarthQueue).to(topicExchange).with("planet.earth");
		}

		@Bean
		public Binding marsPlanetBinding(Queue planetMarsQueue, TopicExchange topicExchange) {
			return BindingBuilder.bind(planetMarsQueue).to(topicExchange).with("planet.mars");
		}

		@Bean
		public Binding planetTopicBinding(Queue planetTopicQueue, TopicExchange topicExchange) {
			return BindingBuilder.bind(planetTopicQueue).to(topicExchange).with("planet.*");
		}

		//Direct Bindings
		@Bean
		public Binding venusPlanetDirectBinding(Queue planetVenusQueue, DirectExchange directExchange) {
			return BindingBuilder.bind(planetVenusQueue).to(directExchange).with("planet.venus");
		}

		@Bean
		public Binding earthPlanetDirectBinding(Queue planetEarthQueue, DirectExchange directExchange) {
			return BindingBuilder.bind(planetEarthQueue).to(directExchange).with("planet.earth");
		}

		@Bean
		public Binding marsPlanetDirectBinding(Queue planetMarsQueue, DirectExchange directExchange) {
			return BindingBuilder.bind(planetMarsQueue).to(directExchange).with("planet.mars");
		}

		//Fanout Bindings
		@Bean
		public Binding venusPlanetFanoutBinding(Queue planetVenusQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(planetVenusQueue).to(fanoutExchange);
		}

		@Bean
		public Binding earthPlanetFanoutBinding(Queue planetEarthQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(planetEarthQueue).to(fanoutExchange);
		}

		@Bean
		public Binding marsPlanetFanoutBinding(Queue planetMarsQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(planetMarsQueue).to(fanoutExchange);
		}
	}
}
