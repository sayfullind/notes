package ru.macloud.telegram_bot_front.bot.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.macloud.telegram_bot_front.bot.Bot;
import ru.macloud.telegram_bot_front.bot.BotService;

@Log4j2
@Service
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {

    private final Bot bot;

    @Override
    public void send(SendMessage sendMessage) {
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Unable to send message: incorrect SendMessage.");
            log.error(e);
        }
    }
}
