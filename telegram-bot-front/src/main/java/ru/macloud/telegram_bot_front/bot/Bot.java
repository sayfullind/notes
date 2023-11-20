package ru.macloud.telegram_bot_front.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.macloud.telegram_bot_front.broker.UpdateProducer;

@Log4j2
@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final UpdateProducer updateProducer;

    @Override
    public void onUpdateReceived(Update update) {
        updateProducer.sendUpdate(update);
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void register() {
        try {
            new TelegramBotsApi(DefaultBotSession.class).registerBot(this);
        } catch (TelegramApiException e) {
            log.error(e);
            throw new RuntimeException(String.format(
                    "Unable to register the bot with token: %s. Check the correctness of the bot's token.",
                    config.getToken())
            );
        }
    }
}
