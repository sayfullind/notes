package ru.macloud.telegram_bot_front.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface BotService {
    void send(SendMessage message);
}
