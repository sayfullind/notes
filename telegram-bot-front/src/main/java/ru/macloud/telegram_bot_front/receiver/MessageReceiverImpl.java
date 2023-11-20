package ru.macloud.telegram_bot_front.receiver;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.macloud.telegram_bot_front.bot.Bot;

@Component
@RequiredArgsConstructor
@RabbitListener (queues = "${broker.send-message-queue}")
public class MessageReceiverImpl {

    private final Bot bot;

    @SneakyThrows
    @RabbitHandler
    public void receiveMessage(SendMessage message) {
        bot.execute(
                message
        );
    }
}
