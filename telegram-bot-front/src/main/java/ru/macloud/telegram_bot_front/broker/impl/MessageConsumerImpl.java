package ru.macloud.telegram_bot_front.broker.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.macloud.telegram_bot_front.bot.BotService;
import ru.macloud.telegram_bot_front.broker.MessageConsumer;

@Component
@RequiredArgsConstructor
@RabbitListener (queues = "${broker.send-message-queue}")
public class MessageConsumerImpl implements MessageConsumer {

    private final BotService service;
    @Override
    @RabbitHandler
    public void recieveMessage(SendMessage message) {
        service.send(message);
    }
}
