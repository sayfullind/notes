package ru.macloud.telegram_bot_front.broker;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerConfig {

    @Value("${broker.update-queue}")
    private String update_queue;

    @Value("${broker.send-message-queue}")
    private String message_queue;

    @Bean
    public Queue updateQueue() {
        return new Queue(update_queue);
    }

    @Bean
    public Queue messageQueue() {
        return new Queue(message_queue);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
