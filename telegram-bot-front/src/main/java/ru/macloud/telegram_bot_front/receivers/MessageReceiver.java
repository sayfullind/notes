package ru.macloud.telegram_bot_front.receivers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface MessageReceiver {
    void receiveMessage(SendMessage message);
}
