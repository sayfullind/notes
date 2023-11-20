package ru.macloud.telegram_bot_front.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateListener {
    void handleUpdate(Update update);
}
