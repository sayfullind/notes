package ru.macloud.telegram_bot_front.broker;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface MessageConsumer {
    void recieveMessage(SendMessage message);
}
