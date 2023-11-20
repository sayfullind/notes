package ru.macloud.telegram_bot_front.bot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BotConfig {

    @Value("${bot.name}")
    private String name;
    @Value("${bot.token}")
    private String token;

}
