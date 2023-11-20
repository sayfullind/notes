package ru.macloud.telegram_bot_front.bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import ru.macloud.telegram_bot_front.config.BotConfig;
import ru.macloud.telegram_bot_front.handlers.UpdateListener;

@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final UpdateListener listener;

    @Override
    public void onUpdateReceived(Update update) {
        listener.handleUpdate(update);
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @SneakyThrows
    @EventListener(ContextRefreshedEvent.class)
    public void register() {
        new TelegramBotsApi(DefaultBotSession.class).registerBot(this);
    }
}
