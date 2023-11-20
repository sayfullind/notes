package ru.macloud.telegram_bot_front.broker;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateProducer {
    void sendUpdate(Update update);
}
