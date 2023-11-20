package ru.macloud.telegram_bot_front.receivers.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.macloud.telegram_bot_front.bot.Bot;
import ru.macloud.telegram_bot_front.receivers.MessageReceiver;

@Component
@RequiredArgsConstructor
@RabbitListener (queues = "${broker.send-message-queue}")
public class MessageReceiverImpl implements MessageReceiver {

    private final Bot bot;

    @Override
    @SneakyThrows
    @RabbitHandler
    public void receiveMessage(SendMessage message) {
        bot.execute(message);
    }
}
