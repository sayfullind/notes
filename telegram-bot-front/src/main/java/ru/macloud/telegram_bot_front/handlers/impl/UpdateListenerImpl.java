package ru.macloud.telegram_bot_front.handlers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.macloud.telegram_bot_front.handlers.UpdateListener;

@Component
@RequiredArgsConstructor
public class UpdateListenerImpl implements UpdateListener {

    private final RabbitTemplate template;
    private final Queue updateQueue;

    @Override
    public void handleUpdate(Update update) {
        this.template.convertAndSend(updateQueue.getName(), update);
    }

}
